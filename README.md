# Enes Selçuk — Portfolio

Personal portfolio site for Enes Selçuk, Android developer focused on Jetpack Compose and Kotlin Multiplatform.

**Live site:** [enesselcuk.com](https://enesselcuk.com)

KMP project with Compose Multiplatform UI, currently shipped as Web/Wasm. Shared modules cover experience, apps, notes, and a downloadable CV. Deployed to Cloudflare Pages via GitHub Actions.

## Tech stack

- Kotlin Multiplatform
- Compose Multiplatform
- Kotlin/Wasm (web)
- Koin, Navigation 3

## Run locally

```bash
./gradlew :app:webApp:wasmJsBrowserDevelopmentRun
```

Then open the URL printed in the terminal (usually `http://127.0.0.1:8080`).

## Deploy

See [docs/DEPLOY.md](docs/DEPLOY.md) for Cloudflare Pages setup.
