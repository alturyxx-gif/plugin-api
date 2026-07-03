package com.zstream.plugin.api

/**
 * Describes the piece of media the plugin should resolve a stream for.
 * Moved from provider/StreamSource.kt — identical shape, new home.
 */
data class MediaRequest(
    val type: Type,
    val tmdbId: String,
    val season: Int? = null,
    val episode: Int? = null,
    /**
     * Optional hint: variant ID the caller wants
     * Sources may use this to prioritise one variant and skip others to
     * avoid unnecessary requests. Ignored if unrecognised.
     */
    val preferredVariantId: String? = null,
) {
    enum class Type { MOVIE, SHOW }
}
