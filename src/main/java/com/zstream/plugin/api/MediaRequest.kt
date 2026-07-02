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
) {
    enum class Type { MOVIE, SHOW }
}
