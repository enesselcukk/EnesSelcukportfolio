# Deploy enesportfolio to Cloudflare Pages

This guide connects `enesselcuk.com` to the Kotlin/Wasm portfolio.

## What gets deployed

GitHub Actions runs:

```bash
./gradlew :app:webApp:packageCloudflarePages
```

Output directory:

```text
app/webApp/build/cloudflare-pages/
```

It contains `index.html`, `styles.css`, `webApp.js`, `.wasm` files, and Compose resources.

## Step 1 — Push the repo to GitHub

1. Create a GitHub repository.
2. Push this project to the `main` branch.

## Step 2 — Create Cloudflare account and Pages project

1. Sign in at [dash.cloudflare.com](https://dash.cloudflare.com).
2. Open **Workers & Pages** → **Create application** → **Pages** → **Upload assets** (Direct Upload).
3. Project name: `enesselcukportfolio`.
4. Upload any placeholder file once, or skip if the UI allows creating an empty project.

Important: do **not** use **Connect to Git** on Cloudflare when deploying with GitHub Actions. That flow often creates a **Worker** project instead of a **Pages** project, and `wrangler pages deploy` then fails with `Project not found [8000007]`.

Use GitHub Actions (`.github/workflows/deploy-cloudflare-pages.yml`) as the only deploy path.

### GitHub Actions secrets

Add these in GitHub → **Settings** → **Secrets and variables** → **Actions**:

| Secret | Where to find it |
|---|---|
| `CLOUDFLARE_API_TOKEN` | Cloudflare → My Profile → API Tokens → Create Token → Edit Cloudflare Workers template |
| `CLOUDFLARE_ACCOUNT_ID` | Cloudflare dashboard URL or **Workers & Pages** overview |

After the first successful deploy, Cloudflare gives you a URL like:

```text
https://enesselcukportfolio.pages.dev
```

The `--project-name` in the GitHub workflow must match the Cloudflare Pages project name exactly.

## Step 3 — Buy the domain

You can buy `enesselcuk.com` from Squarespace or anywhere else.

Recommended long-term setup:

1. Buy the domain.
2. Add the domain to Cloudflare as a site.
3. Change the domain nameservers at Squarespace to the Cloudflare nameservers.

That makes DNS, SSL, and Pages custom domains much easier.

## Step 4 — Connect the custom domain

In Cloudflare Pages → your project → **Custom domains**:

1. Add `enesselcuk.com`
2. Add `www.enesselcuk.com`
3. Enable redirect from `www` to apex, or the reverse — pick one canonical URL.

If DNS is managed by Cloudflare, records are created automatically.

If DNS stays at Squarespace temporarily:

| Type | Name | Target |
|---|---|---|
| CNAME | `www` | `enesselcukportfolio.pages.dev` |
| ALIAS / ANAME / forwarding | `@` | Cloudflare Pages target shown in the dashboard |

Squarespace apex (`@`) support varies. Moving nameservers to Cloudflare is the most reliable option.

## Step 5 — Verify

Check:

- [ ] `https://enesselcuk.com` loads the portfolio
- [ ] `https://www.enesselcuk.com` redirects correctly
- [ ] TR/EN language toggle works
- [ ] CV download works
- [ ] Mobile layout looks correct

## Local production preview

```bash
./gradlew :app:webApp:packageCloudflarePages
cd app/webApp/build/cloudflare-pages
python3 -m http.server 8080
```

Open `http://127.0.0.1:8080`.

## Regenerate the embedded CV

```bash
python3 tools/cv/generate_cv_pdf.py
./gradlew :app:webApp:packageCloudflarePages
```

## Troubleshooting

### Blank page after deploy

- Confirm `index.html` and `styles.css` exist in the Pages output directory.
- Check browser devtools for failed `.wasm` requests.

### CV download fails

- Rebuild after updating `feature/portfolio/presentation/src/commonMain/composeResources/files/enes_selcuk_cv.pdf`.

### GitHub Action fails on Gradle

- Java 21 is required.
- First CI run may take several minutes while Gradle caches dependencies.
