# Plugin API

**Public contract for ZStream stream plugins.** Defines the interface that all streaming sources must implement to work with ZStream.

This is a shared library used by both the Android app and the private plugin implementation. Keep API surface stable and backward-compatible.

## Breaking Changes

Any **signature change** to:
- `StreamPlugin.resolve()` parameter or return type
- `Variant` fields or nullability
- `MediaRequest` / `SourceInfo` / `Caption` fields

requires coordination between:
1. **plugin-api** (this repo) — source of truth
2. **app** (`ZStream-Android/app`) — Android client
3. **zstream-plugin** (private repo) — implementation

## Testing

Plugin API has no unit tests—it's pure data definitions. Integration testing happens in:
- **zstream-plugin** — tests the implementation
- **app** — end-to-end tests with a test plugin or mock `StreamPlugin`

