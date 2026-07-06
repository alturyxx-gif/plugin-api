package com.zstream.plugin.api

/**
 * Contract between the open-source app and the closed-source plugin APK.
 *
 * The plugin APK must contain a class at exactly `com.zstream.plugin.Entry`
 * that implements this interface. The app locates and loads it via DexClassLoader.
 *
 * Rules:
 * - resolve() must never throw. Return StreamResult.Error instead.
 * - resolve() must be safe to call concurrently from multiple coroutines.
 * - The plugin receives only what it needs: a MediaRequest and a sourceId.
 *   No NavController, ViewModel, Context, DataStore, or database handle is passed in.
 */
interface StreamPlugin {
    /** Plugin build version. Must increase monotonically with each release. */
    val version: Int

    /**
     * Returns the list of sources this plugin knows about, in the plugin's
     * preferred default order. The app may reorder these based on user preference.
     * Must return a stable list — do not shuffle or randomise.
     */
    fun availableSources(): List<SourceInfo>

    /**
     * Attempt to resolve a playable stream for [media] using the source identified
     * by [sourceId]. Called once per source by the app's resolution loop.
     *
     * [sourceId] will always be a value previously returned by [availableSources].
     * If [sourceId] is unrecognised, return [StreamResult.Error].
     */
    suspend fun resolve(media: MediaRequest, sourceId: String): StreamResult =
        resolve(media)
}
