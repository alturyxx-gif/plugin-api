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
        val codec: String = "",                    // e.g. "hevc", "h264", "" if unknown
        val variants: List<Variant> = emptyList(), // all available variants for the picker
        /**
         * True if the CDN URL expires quickly after resolution (e.g. signed tokens with
         * short TTL). When set, the app skips the HLS probe that would otherwise consume
         * the token before ExoPlayer gets it.
         */
        val skipProbe: Boolean = false,
    ) : StreamResult()

    /** A single playable variant returned alongside the primary stream. */
    data class Variant(
        val id: String,           // unique identifier (fid)
        val name: String,         // display name from API e.g. "1080p HEVC"
        val quality: String,      // e.g. "4K", "1080p"
        val codec: String,        // e.g. "hevc", "h264", ""
        val tag: String,          // e.g. "hdr", "dv", "remux", "bw", ""
        val streamUrl: String,    // decrypted HLS URL
        val streamType: String = "hls",
        val headers: Map<String, String> = emptyMap(),
        /**
         * True if the stream URL expires shortly after resolution (e.g. signed CDN tokens).
         * When the user switches to this variant, the app should re-resolve the source to
         * obtain a fresh URL rather than using the cached one.
         */
        val requiresRefreshOnSwitch: Boolean = false,
    )

    /** Source had no result for this media (not found, region-locked, etc.). Try next source. */
    object NotFound : StreamResult()

    /** A recoverable or non-recoverable error occurred. Message is for logging only. */
    data class Error(val message: String) : StreamResult()
}
