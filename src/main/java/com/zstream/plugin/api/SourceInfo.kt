package com.zstream.plugin.api

/**
 * Describes a single stream source the plugin knows about.
 * The app uses this to build the per-source status list in the player UI.
 */
data class SourceInfo(
    val id: String,
    val displayName: String,
)
