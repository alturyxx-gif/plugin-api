package com.zstream.plugin.api

/**
 * The result of a single source resolution attempt.
 * The plugin must never throw from resolve() — return Error instead.
 */
sealed class StreamResult {
    data class Success(
        val streamUrl: String,
        val streamType: String,                    // "hls" or "file"
        val captions: List<Caption> = emptyList(),
        val headers: Map<String, String> = emptyMap(),
    ) : StreamResult()

    /** Source had no result for this media (not found, region-locked, etc.). Try next source. */
    object NotFound : StreamResult()

    /** A recoverable or non-recoverable error occurred. Message is for logging only. */
    data class Error(val message: String) : StreamResult()
}
