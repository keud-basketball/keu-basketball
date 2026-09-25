# keu-basketball
KEU Basketball — a lightweight multiplayer Philippine basketball strategy game featuring PBA and NCAA-inspired teams, player stats, roulette drafting, team building, and simulated basketball battles.

## Android build

The Android wrapper uses Capacitor and keeps `index.html` as the web app source. Install dependencies and sync the native project with:

```bash
npm ci
npm run android:sync
```

The GitHub Actions workflow builds a DEBUG APK with Java 21 and uploads `app-debug.apk` as the `keu-debug-apk` artifact. The local container may not build Android if its Java version is newer than the Gradle version used by Capacitor.
