#!/usr/bin/env python3
"""Generate Enes Selcuk CV PDF (B2 English, with metrics placeholders)."""

from reportlab.lib import colors
from reportlab.lib.enums import TA_LEFT
from reportlab.lib.pagesizes import A4
from reportlab.lib.styles import ParagraphStyle, getSampleStyleSheet
from reportlab.lib.units import mm
from reportlab.pdfbase import pdfmetrics
from reportlab.pdfbase.ttfonts import TTFont

FONT_DIR = "/System/Library/Fonts/Supplemental"
FONT = "Arial"
FONT_BOLD = "Arial-Bold"
FONT_ITALIC = "Arial-Italic"
FONT_BOLD_ITALIC = "Arial-BoldItalic"


def register_fonts():
    pdfmetrics.registerFont(TTFont(FONT, f"{FONT_DIR}/Arial.ttf"))
    pdfmetrics.registerFont(TTFont(FONT_BOLD, f"{FONT_DIR}/Arial Bold.ttf"))
    pdfmetrics.registerFont(TTFont(FONT_ITALIC, f"{FONT_DIR}/Arial Italic.ttf"))
    pdfmetrics.registerFont(TTFont(FONT_BOLD_ITALIC, f"{FONT_DIR}/Arial Bold Italic.ttf"))
    pdfmetrics.registerFontFamily(
        FONT,
        normal=FONT,
        bold=FONT_BOLD,
        italic=FONT_ITALIC,
        boldItalic=FONT_BOLD_ITALIC,
    )
from pathlib import Path
from reportlab.platypus import (
    HRFlowable,
    Paragraph,
    SimpleDocTemplate,
    Spacer,
    Table,
    TableStyle,
)

SCRIPT_DIR = Path(__file__).resolve().parent
REPO_ROOT = SCRIPT_DIR.parent.parent
OUTPUT = REPO_ROOT / "feature/portfolio/presentation/src/commonMain/composeResources/files/enes_selcuk_cv.pdf"


def build_styles():
    base = getSampleStyleSheet()
    return {
        "name": ParagraphStyle(
            "Name",
            parent=base["Heading1"],
            fontName=FONT_BOLD,
            fontSize=20,
            leading=24,
            spaceAfter=2,
            textColor=colors.HexColor("#1a1a1a"),
        ),
        "title": ParagraphStyle(
            "Title",
            parent=base["Normal"],
            fontName=FONT,
            fontSize=11,
            leading=14,
            spaceAfter=4,
            textColor=colors.HexColor("#444444"),
        ),
        "contact": ParagraphStyle(
            "Contact",
            parent=base["Normal"],
            fontName=FONT,
            fontSize=9,
            leading=12,
            spaceAfter=10,
            textColor=colors.HexColor("#555555"),
        ),
        "section": ParagraphStyle(
            "Section",
            parent=base["Heading2"],
            fontName=FONT_BOLD,
            fontSize=11,
            leading=14,
            spaceBefore=10,
            spaceAfter=6,
            textColor=colors.HexColor("#1a1a1a"),
        ),
        "job_title": ParagraphStyle(
            "JobTitle",
            parent=base["Normal"],
            fontName=FONT_BOLD,
            fontSize=10,
            leading=13,
            spaceAfter=1,
        ),
        "job_meta": ParagraphStyle(
            "JobMeta",
            parent=base["Normal"],
            fontName=FONT_ITALIC,
            fontSize=9,
            leading=12,
            spaceAfter=4,
            textColor=colors.HexColor("#444444"),
        ),
        "body": ParagraphStyle(
            "Body",
            parent=base["Normal"],
            fontName=FONT,
            fontSize=9.5,
            leading=13,
            spaceAfter=6,
            alignment=TA_LEFT,
        ),
        "bullet": ParagraphStyle(
            "Bullet",
            parent=base["Normal"],
            fontName=FONT,
            fontSize=9.5,
            leading=13,
            leftIndent=12,
            bulletIndent=0,
            spaceAfter=4,
        ),
        "skills_label": ParagraphStyle(
            "SkillsLabel",
            parent=base["Normal"],
            fontName=FONT_BOLD,
            fontSize=9.5,
            leading=13,
        ),
        "skills_value": ParagraphStyle(
            "SkillsValue",
            parent=base["Normal"],
            fontName=FONT,
            fontSize=9.5,
            leading=13,
        ),
        "table_cell": ParagraphStyle(
            "TableCell",
            parent=base["Normal"],
            fontName=FONT,
            fontSize=9,
            leading=12,
        ),
        "table_header": ParagraphStyle(
            "TableHeader",
            parent=base["Normal"],
            fontName=FONT_BOLD,
            fontSize=9,
            leading=12,
        ),
    }


def section_rule():
    return HRFlowable(width="100%", thickness=0.6, color=colors.HexColor("#cccccc"), spaceAfter=6)


def bullet(text, style):
    return Paragraph(f"• {text}", style)


def main():
    register_fonts()
    styles = build_styles()
    doc = SimpleDocTemplate(
        str(OUTPUT),
        pagesize=A4,
        leftMargin=18 * mm,
        rightMargin=18 * mm,
        topMargin=16 * mm,
        bottomMargin=16 * mm,
    )
    story = []

    story.append(Paragraph("ENES SELÇUK", styles["name"]))
    story.append(Paragraph("Android Developer", styles["title"]))
    story.append(
        Paragraph(
            'İstanbul, Turkey | +90 552 686 82 25 | '
            '<a href="mailto:enesselcu25@gmail.com" color="#1a56db">enesselcu25@gmail.com</a> | '
            '<a href="https://enesselcuk.com" color="#1a56db">Portfolio</a> | '
            '<a href="https://github.com/enesselcukk" color="#1a56db">GitHub</a> | '
            '<a href="https://www.linkedin.com/in/enes-selçuk-26a9ba18a/" color="#1a56db">LinkedIn</a> | '
            '<a href="https://medium.com/@enesselcuk" color="#1a56db">Medium</a>',
            styles["contact"],
        )
    )
    story.append(section_rule())

    story.append(Paragraph("PROFESSIONAL SUMMARY", styles["section"]))
    story.append(
        Paragraph(
            "Android Developer with <b>5+ years</b> of experience. I build production Android apps, secure banking SDKs, "
            "and cross-platform applications with <b>Kotlin</b>, <b>Jetpack Compose</b>, "
            "<b>Kotlin Multiplatform (KMP)</b>, and <b>Compose Multiplatform (CMP)</b>. "
            "On KMP projects, I built the shared network layer with <b>Ktor Client</b>, using the <b>Darwin</b> engine for iOS. "
            "I worked on projects for <b>Garanti BBVA</b>, <b>Migros</b>, <b>Hürriyet</b>, <b>Havaş</b>, and <b>İŞMER Intranet</b>. "
            "I focus on <b>MVI/MVVM</b>, <b>Server-Driven UI (SDUI)</b>, mobile security "
            "(<b>mTLS</b>, biometrics, <b>KYC/NFC</b>), and multi-module architecture. "
            "I also work on <b>CI/CD</b> pipelines and <b>unit/UI testing</b>.",
            styles["body"],
        )
    )

    story.append(Paragraph("PROFESSIONAL EXPERIENCE", styles["section"]))
    story.append(section_rule())

    # Eteration
    story.append(Paragraph("Eteration Bilişim A.Ş. (Contractor at Garanti BBVA Bank)", styles["job_title"]))
    story.append(Paragraph("Senior / Mid Android Developer | Oct 2023 – Apr 2026 · 30+ member cross-functional team", styles["job_meta"]))
    eteration_bullets = [
        "Built a <b>modular SDUI SDK</b> with Jetpack Compose and MVI for <b>10+ screens/flows</b>. The backend team can update UI <b>without app store releases</b>, replacing a <b>monthly release cycle</b> with instant backend-driven changes.",
        "Implemented <b>mTLS</b>, certificate pinning, and secure token auth for App-to-App banking. This removed unauthorized third-party access and <b>passed the security audit with zero critical findings</b> on first review.",
        "Developed <b>KYC SDKs</b> with NFC ID scan, OCR, and liveness check. Onboarding time dropped from <b>8 min → 3 min</b> and verification success rate reached <b>92%</b>.",
        "Built a <b>Server Push SDK</b> by integrating the third-party <b>HiveMQ</b> library with Kotlin Flow, Channels, and MVI. During ATM cash withdrawals, the mobile banking screen updates <b>automatically without manual refresh</b>. The solution was designed for <b>high performance and reliability</b> in critical banking flows.",
        "Delivered <b>Login SDK</b> and <b>Approve SDK</b> for individual and corporate banking with custom Manual DI. Memory use went down by <b>18%</b> and login flow bugs dropped by <b>45%</b> after release.",
        "Wrote <b>50+ Unit and Compose UI tests</b> (JUnit, Espresso, Mockito) and set up <b>Jenkins CI/CD</b>. Test coverage reached <b>80%</b> and pipeline time went from <b>38 min → 14 min</b>.",
        "Used <b>GitHub Copilot</b> and <b>ChatGPT</b> to increase development efficiency and improve code quality.",
    ]
    for b in eteration_bullets:
        story.append(bullet(b, styles["bullet"]))
    story.append(Spacer(1, 6))

    # Nuevo
    story.append(Paragraph("Nuevo Softwarehouse", styles["job_title"]))
    story.append(Paragraph("Android Developer | Jun 2022 – Oct 2023 · 15+ member engineering team", styles["job_meta"]))
    nuevo_bullets = [
        "Led <b>İŞMER İntranet</b> end-to-end as the primary Android developer: made all <b>architectural decisions</b> (MVVM, modular structure, API integration) and built the corporate employee portal (news, announcements, directory, feedback modules). Delivered production releases on <b>Google Play</b>, <b>Huawei AppGallery</b>, and the <b>App Store</b>.",
        "Maintained and improved Android apps for <b>Migros-İK, Hürriyet, Havaş, OYAK</b>, and <b>Avivasa</b>. Apps serve <b>500K+ / 1M+</b> active users. Crash-free rate improved from <b>98.5% → 99.4%</b>.",
        "Refactored legacy <b>Java/Kotlin</b> code to <b>MVVM</b> with Coroutines and Flow. We removed <b>50+</b> old modules/classes and cut build time by <b>25%</b>.",
        "Integrated <b>WebView</b> for live reports and dynamic content, enabling flexible web-based updates without native app releases.",
        "Managed store releases and production delivery for multiple client apps on <b>Google Play</b> and <b>Huawei AppGallery (HMS)</b>.",
        "Mentored intern developers: <b>code reviews</b>, onboarding, and day-to-day Android delivery.",
    ]
    for b in nuevo_bullets:
        story.append(bullet(b, styles["bullet"]))
    story.append(Spacer(1, 6))

    # University
    story.append(Paragraph("Osmaniye Korkut Ata University (IT Dept.)", styles["job_title"]))
    story.append(Paragraph("Part-Time Android Developer | Jul 2020 – Apr 2022 · 5 member development team", styles["job_meta"]))
    for b in [
        "Developed a youth center app with member registration, news, and authentication "
        "features using <b>Java</b> and <b>MVP</b>; implemented the authentication layer with "
        "<b>Firebase</b>.",
        "Contributed to the official university mobile app built with <b>Kotlin</b>, "
        "<b>MVVM</b>, and <b>Firebase</b>, including login and campus news feed modules.",
    ]:
        story.append(bullet(b, styles["bullet"]))

    story.append(Paragraph("TECHNICAL SKILLS", styles["section"]))
    story.append(section_rule())
    skills = [
        ("Languages", "Kotlin, Java, C#, SQL"),
        ("Android & KMP", "Jetpack Compose, CMP, KMP, Coroutines, Flow, Room, Retrofit, Hilt, Koin, Manual DI, ViewModel, Navigation"),
        ("Networking / iOS", "Ktor, Ktor Client, Darwin (iOS)"),
        ("Architecture", "Clean Architecture, MVI, MVVM, Multi-Module, Repository Pattern, DI (Hilt / Manual / Koin), SDUI"),
        ("Security & Hardware", "mTLS/TLS, Biometrics, KYC, NFC, Android Keystore, EncryptedSharedPreferences (AES256-SIV/GCM), MasterKey, Room with SQLCipher, R8 Obfuscation, Root Detection, Certificate Pinning, OCR, Liveness, QR Code"),
        ("CI/CD & Tools", "Git, Jenkins, GitHub Actions, Gradle, JUnit, Espresso, Mockito, Android Studio, Firebase"),
        ("Methodologies", "Agile, Scrum, Kanban"),
    ]
    skill_rows = [
        [Paragraph(label, styles["skills_label"]), Paragraph(value, styles["skills_value"])]
        for label, value in skills
    ]
    skill_table = Table(skill_rows, colWidths=[38 * mm, 132 * mm])
    skill_table.setStyle(
        TableStyle(
            [
                ("VALIGN", (0, 0), (-1, -1), "TOP"),
                ("TOPPADDING", (0, 0), (-1, -1), 2),
                ("BOTTOMPADDING", (0, 0), (-1, -1), 4),
            ]
        )
    )
    story.append(skill_table)

    story.append(Paragraph("EDUCATION", styles["section"]))
    story.append(section_rule())
    story.append(Paragraph("Sakarya University", styles["job_title"]))
    story.append(
        Paragraph(
            "Master of Science in Management Information Systems (Thesis) | 2026 – 2027",
            styles["job_meta"],
        )
    )
    story.append(Spacer(1, 4))
    story.append(Paragraph("Osmaniye Korkut Ata University", styles["job_title"]))
    story.append(
        Paragraph(
            "Bachelor of Science in Management Information Systems | 2018 – 2022 | GPA: 3.6 / 4.0",
            styles["job_meta"],
        )
    )

    story.append(Paragraph("FEATURED PRODUCTION APPS & PROJECTS", styles["section"]))
    story.append(section_rule())
    apps = [
        (
            "Garanti BBVA Mobile",
            "Banking SDKs: SDUI, Login, Approve, KYC, and Server Push.",
            "https://play.google.com/store/apps/details?id=com.garanti.cepsubesi",
        ),
        (
            "Migros İK",
            "Employee portal and QR authentication.",
            "https://play.google.com/store/apps/details?id=tr.migros.fiori",
        ),
        (
            "Hürriyet",
            "High-traffic news and media app.",
            "https://play.google.com/store/apps/details?id=hurriyet.mobil.android",
        ),
        (
            "Havaş Mobile",
            "Enterprise transport and logistics platform.",
            "https://play.google.com/store/apps/details?id=com.havas.mobile",
        ),
        (
            "Renault PORT",
            "Automotive customer portal.",
            "https://play.google.com/store/apps/details?id=tr.com.renault.port",
        ),
        (
            "İŞMER İntranet",
            "Corporate intranet. Architecture owned end to end.",
            "https://play.google.com/store/apps/details?id=com.ismer.portal",
        ),
    ]
    for name, focus, url in apps:
        story.append(
            Paragraph(
                f"<b>{name}</b> {focus} "
                f'<a href="{url}" color="#1a56db">Google Play Link</a>',
                styles["body"],
            )
        )

    story.append(Spacer(1, 6))
    story.append(Paragraph("PERSONAL PROJECTS (KMP / CMP)", styles["section"]))
    story.append(section_rule())
    personal_projects = [
        (
            "Spotter",
            "Compose Multiplatform app with shared UI across Android and iOS. Modular features and a Material 3 design system.",
            "https://github.com/enesselcukk/Spotter",
        ),
        (
            "KMPNews",
            "Kotlin Multiplatform news client with shared domain, data, and presentation in commonMain, and Ktor Client networking (Darwin on iOS).",
            "https://github.com/enesselcukk/KMPNews",
        ),
        (
            "FieldFlow",
            "Multi-module Android app in Kotlin and Jetpack Compose (MVVM). Room + SQLCipher at rest; AES-GCM and Android Keystore.",
            "https://github.com/enesselcukk/FieldFlow",
        ),
        (
            "EnesSelcukportfolio",
            "Personal site in Kotlin and Compose Multiplatform (web). Responsive layout and a shared design system.",
            "https://github.com/enesselcukk/EnesSelcukportfolio",
        ),
    ]
    for name, focus, url in personal_projects:
        story.append(
            Paragraph(
                f"<b>{name}</b> {focus} "
                f'<a href="{url}" color="#1a56db">GitHub Link</a>',
                styles["body"],
            )
        )

    doc.build(story)
    print(f"Created: {OUTPUT}")


if __name__ == "__main__":
    main()
