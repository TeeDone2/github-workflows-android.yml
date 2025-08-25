# JarvisX (Starter)

This is a **starter** Android project scaffold for JarvisX. It includes:
- AccessibilityService for screen awareness and UI control
- Foreground voice service placeholder for wake word / VAD
- Overlay service for always-on controls
- SecureVault using EncryptedSharedPreferences
- MYMLLM autonomy core stubs (AgentCore, SkillsRegistry)

> Open in **Android Studio (Giraffe or newer)** and build. Grant Accessibility + Overlay permissions after install.

## Build
1. Open the folder in Android Studio.
2. Let Gradle sync. If wrapper prompts, let AS upgrade.
3. Build > Build APK(s). Install the generated APK on your device.

## Next steps (high-level)
- Replace wake-word placeholder with on-device model (e.g., Porcupine, Vosk, or Whisper tiny w/ VAD).
- Implement speaker verification (ECAPA-TDNN) for voice-only unlock; require biometric fallback if mismatch.
- Add OCR with ML Kit; parse view trees via `rootInActiveWindow` for semantic actions.
- Integrate Supabase (PostgREST + Edge Functions) and n8n with keys stored in SecureVault.
- Expand `AgentCore` to run MYMLLM protocol and skills from `SkillsRegistry`.