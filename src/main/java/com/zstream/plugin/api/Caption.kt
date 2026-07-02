package com.zstream.plugin.api

/**
 * A single subtitle/caption track returned by the plugin alongside a resolved stream.
 * Shape matches the existing SubtitleTrack mapping in PlayerViewModel.
 */
data class Caption(
    val url: String,
    val language: String,
    val langIso: String,
    val type: String, // "vtt", "srt", etc.
)
