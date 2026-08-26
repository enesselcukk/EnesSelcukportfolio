package com.example.enesportfolio.feature.portfolio.data

import com.example.enesportfolio.core.model.AppLanguage
import com.example.enesportfolio.core.model.GitHubShowcase
import com.example.enesportfolio.core.model.Links
import com.example.enesportfolio.core.model.NoteItem
import com.example.enesportfolio.core.model.PortfolioContent
import com.example.enesportfolio.core.model.PortfolioCopy
import com.example.enesportfolio.core.model.ProjectItem
import com.example.enesportfolio.core.model.SkillGroup

internal object PortfolioCopyData {
  private val englishCopy = PortfolioCopy(
    skip = "Skip to content",
    navExperience = "Experience",
    navWork = "Apps",
    navNotes = "Notes",
    heroOverline = "Android · Jetpack Compose · KMP",
    heroRole = "Android Developer",
    heroLede =
      "I've been writing Android apps and banking SDKs in Kotlin and Java for 5+ years. At Garanti BBVA I did professional development work with Jetpack Compose. I also worked on Migros İK, Hürriyet, Havaş, and İŞMER Intranet. In my personal projects I am actively interested in Kotlin Multiplatform; I also use Compose Multiplatform.",
    downloadCv = "Download CV",
    portraitCaption = "İstanbul, Türkiye",
    aboutTitle = "Expertise",
    aboutLead = "I write banking SDKs and corporate Android apps. I was also responsible for architecture, security, and store release.",
    aboutArchLabel = "Architecture",
    aboutArch = "MVI, MVVM, and server-driven UI (SDUI). Multi-module codebases.",
    aboutSecLabel = "Security",
    aboutSec = "mTLS/TLS, biometrics, KYC, and NFC.",
    aboutShipLabel = "Delivery",
    aboutShip = "CI/CD, unit and UI tests. Google Play and Huawei AppGallery.",
    nowLabel = "Current focus",
    nowOne = "Spotter — shared UI on Android and iOS with Compose Multiplatform (personal project)",
    nowTwo = "KMPNews — shared business logic and data layer with Kotlin Multiplatform (personal project)",
    nowThree = "Technical writing on Android architecture and engineering practices on Medium",
    expOverline = "Experience",
    expTitle = "Professional experience",
    j1When = "Oct 2023 – Apr 2026",
    j1Role = "Senior / Mid Android Developer · Contractor at Garanti BBVA",
    j1a = "Built a modular SDUI SDK with Jetpack Compose and MVI covering 10+ screens, enabling backend-driven UI updates without app store releases.",
    j1b = "Delivered Login SDK and Approve SDK with a custom Manual DI setup for individual and corporate banking flows.",
    j1c = "Developed KYC SDKs with NFC ID scanning, OCR, and liveness checks. Onboarding time fell from 8 minutes to 3; verification success reached 92%.",
    j1d = "Built a Server Push SDK on top of a third-party library, implementing the integration end to end from vendor documentation.",
    j1e = "Implemented mTLS/TLS, certificate pinning, and secure token authentication for app-to-app banking. The first security audit returned zero critical findings.",
    j1f = "Wrote 50+ unit and Compose UI tests and set up Jenkins CI/CD. Coverage reached 80%; pipeline time dropped from 38 minutes to 14.",
    j1g =
      "At Eteration on Garanti BBVA projects, used GitHub Copilot and ChatGPT to increase development efficiency and improve code quality.",
    j1Team = "Worked in a team of 20+.",
    j2When = "Jun 2022 – Oct 2023",
    j2Role = "Android Developer",
    j2a = "Owned the architecture of İŞMER Intranet end to end and shipped the app to Google Play and Huawei AppGallery.",
    j2b = "Maintained and improved Android apps for Migros İK, Hürriyet, Havaş, OYAK, and Avivasa, serving 500K+ / 1M+ active users. Crash-free rate improved from 98.5% to 99.4%.",
    j2c = "Refactored legacy Java/Kotlin to MVVM with Coroutines and Flow. Removed 50+ obsolete modules and reduced build time by 25%.",
    j2Team = "Worked in a team of 10.",
    j3When = "Jul 2020 – Apr 2022",
    j3Company = "Osmaniye Korkut Ata University — IT Department",
    j3Role = "Part-time Android Developer",
    j3Team = "Worked in a team of 5.",
    j3a = "I developed a youth center app covering member registration, news, and auth.",
    j3b = "The first app was built in Java using MVP.",
    j3c = "I implemented the auth layer with Firebase.",
    j3d = "I was on the team that developed the official university app with Kotlin, MVVM, and Firebase, including login and a campus news feed.",
    stackOverline = "Skills",
    stackTitle = "Technical skills",
    stackLang = "Languages",
    stackAndroid = "Android & KMP",
    stackArch = "Architecture",
    stackSec = "Security",
    stackCi = "CI/CD & tests",
    eduOverline = "Education",
    eduUniversity = "Osmaniye Korkut Ata University",
    eduDegree = "B.S. Management Information Systems",
    eduWhen = "2018 – 2022 · GPA 3.6 / 4.0",
    prodOverline = "Applications",
    prodTitle = "Selected applications",
    app1 = "Banking SDKs: SDUI, Login, Approve, KYC, and Server Push.",
    app2 = "Employee portal and QR authentication.",
    app3 = "High-traffic news and media app.",
    app4 = "Enterprise transport and logistics platform.",
    app5 = "Automotive customer portal.",
    app6 = "Corporate intranet. Architecture owned end to end.",
    openPlay = "View on Google Play",
    persOverline = "Personal",
    persTitle = "KMP / CMP",
    projSpotter =
      "Compose Multiplatform app with shared UI across Android and iOS. Modular features and a cohesive Material 3 design system.",
    projNews =
      "Kotlin Multiplatform news client with shared domain, data, and presentation layers. Network and persistence live in commonMain.",
    projPortfolio =
      "Personal portfolio built with Kotlin and Compose Multiplatform (web). Responsive layout, scroll-driven motion, and a shared design system.",
    openRepo = "View on GitHub",
    notesOverline = "Notes",
    notesTitle = "Writing",
    note1 = "Local-first / offline-first on Android — Room, Flow, WorkManager",
    note2 = "WorkManager on modern Android — standards and practice",
    noteMoreWhen = "More",
    note3 = "Design patterns in Compose, and the rest on Medium",
    footerFocus = "Focused on architecture, server-driven UI, and mobile security.",
  )

  private val turkishCopy = PortfolioCopy(
    skip = "İçeriğe geç",
    navExperience = "Deneyim",
    navWork = "Uygulamalar",
    navNotes = "Yazılar",
    heroOverline = "Android · Jetpack Compose · KMP",
    heroRole = "Android Developer",
    heroLede =
      "Beş yılı aşkın süredir Kotlin ve Java ile Android uygulamaları ve bankacılık SDK'ları yazıyorum. Garanti BBVA'da Jetpack Compose ile profesyonel geliştirmeler yaptım. Migros İK, Hürriyet, Havaş ve İŞMER Intranet'te de çalıştım. Kişisel projelerimde Kotlin Multiplatform ile aktif olarak ilgileniyorum; Compose Multiplatform'u da kullanıyorum.",
    downloadCv = "CV'yi indir",
    portraitCaption = "İstanbul, Türkiye",
    aboutTitle = "Uzmanlık",
    aboutLead = "Bankacılık SDK'ları ve kurumsal Android uygulamaları yazıyorum. Architecture, security ve store release süreçlerinden de sorumluydum.",
    aboutArchLabel = "Mimari",
    aboutArch = "MVI, MVVM ve server-driven UI (SDUI). Multi-module.",
    aboutSecLabel = "Güvenlik",
    aboutSec = "mTLS/TLS, biometrics, KYC ve NFC.",
    aboutShipLabel = "Teslim",
    aboutShip = "CI/CD, unit ve UI testleri. Google Play ve Huawei AppGallery.",
    nowLabel = "Güncel odak",
    nowOne = "Spotter — Compose Multiplatform ile Android ve iOS'ta ortak arayüz (kişisel proje)",
    nowTwo = "KMPNews — Kotlin Multiplatform ile ortak iş kuralı ve veri katmanı (kişisel proje)",
    nowThree = "Medium'da Android mimarisi ve mühendislik pratikleri üzerine yazıyorum",
    expOverline = "Deneyim",
    expTitle = "Profesyonel deneyim",
    j1When = "Ekim 2023 – Nisan 2026",
    j1Role = "Senior / Mid Android Developer · Garanti BBVA (contractor)",
    j1a = "Jetpack Compose ve MVI ile 10'dan fazla ekranı kapsayan modüler bir SDUI SDK yazdım. Arayüz, mağaza sürümü çıkmadan backend'den güncellenebiliyor.",
    j1b = "Bireysel ve kurumsal bankacılık için Login SDK ve Approve SDK geliştirdim. Bağımlılıkları Manual DI ile yönettim.",
    j1c = "NFC ile kimlik okuma, OCR ve canlılık kontrolü olan KYC SDK'ları yazdım. Onboarding 8 dakikadan 3 dakikaya indi, doğrulama başarı oranı %92 oldu.",
    j1d = "Hazır bir kütüphane üzerine Server Push SDK yazdım. Entegrasyonu dokümantasyondan okuyup baştan sona ben kurdum.",
    j1e = "Uygulamalar arası bankacılık için mTLS/TLS, sertifika sabitleme ve güvenli token doğrulaması ekledim. İlk güvenlik denetiminde kritik açık çıkmadı.",
    j1f = "50'den fazla unit ve Compose UI testi yazdım; Jenkins üzerinde CI/CD kurdum. Test kapsamı %80'e çıktı, pipeline 38 dakikadan 14 dakikaya indi.",
    j1g =
      "Garanti işlerinde GitHub Copilot ve ChatGPT'yi günlük kullandım; tekrarlayan işleri ve kod taramasını hızlandırmak için.",
    j1Team = "20+ kişilik bir takımda çalıştım.",
    j2When = "Haziran 2022 – Ekim 2023",
    j2Role = "Android Developer",
    j2a = "İŞMER İntranet'in mimarisini ben kurguladım. Uygulamayı Google Play ve Huawei AppGallery'ye çıkardım.",
    j2b = "Migros İK, Hürriyet, Havaş, OYAK ve Avivasa uygulamalarını geliştirdim ve canlıda tuttum. Kullanıcı sayısı 500 bin–1 milyon bandında; çökmesiz oran %98,5'ten %99,4'e çıktı.",
    j2c = "Eski Java/Kotlin kodunu Coroutines ve Flow ile MVVM'e taşıdım. 50'den fazla kullanılmayan modülü kaldırdım; derleme süresi %25 kısaldı.",
    j2Team = "10 kişilik bir takımda çalıştık.",
    j3When = "Temmuz 2020 – Nisan 2022",
    j3Company = "Osmaniye Korkut Ata Üniversitesi — Bilgi İşlem",
    j3Role = "Yarı zamanlı Android Developer",
    j3Team = "5 kişilik bir ekipte çalıştık.",
    j3a = "Gençlik merkezi için üye kayıt, haber ve auth süreçlerini kapsayan bir uygulama geliştirdim.",
    j3b = "İlk uygulamayı Java ile geliştirdik; mimari olarak MVP kullandık.",
    j3c = "Auth katmanını Firebase üzerinde ben geliştirdim.",
    j3d = "Üniversitenin resmi uygulamasını Kotlin, MVVM ve Firebase ile geliştiren ekipte yer aldım; giriş ve kampüs haberleri bu kapsamdaydı.",
    stackOverline = "Yetkinlikler",
    stackTitle = "Teknik yetkinlikler",
    stackLang = "Diller",
    stackAndroid = "Android & KMP",
    stackArch = "Mimari",
    stackSec = "Güvenlik",
    stackCi = "CI/CD & test",
    eduOverline = "Eğitim",
    eduUniversity = "Osmaniye Korkut Ata Üniversitesi",
    eduDegree = "Yönetim Bilişim Sistemleri, Lisans",
    eduWhen = "2018 – 2022 · GANO 3.6 / 4.0",
    prodOverline = "Uygulamalar",
    prodTitle = "Çalıştığım uygulamalar",
    app1 = "Bankacılık SDK'ları: SDUI, Login, Approve, KYC ve Server Push.",
    app2 = "Çalışan portalı ve QR ile kimlik doğrulama.",
    app3 = "Yoğun trafikli haber uygulaması.",
    app4 = "Kurumsal ulaşım ve lojistik uygulaması.",
    app5 = "Otomotiv müşteri portalı.",
    app6 = "Kurumsal intranet. Mimariyi ben kurguladım.",
    openPlay = "Google Play'de görüntüle",
    persOverline = "Kişisel",
    persTitle = "KMP / CMP",
    projSpotter =
      "Android ve iOS için ortak arayüzlü Compose Multiplatform uygulaması. Modüler yapı, Material 3.",
    projNews =
      "Ortak domain, data ve presentation katmanına sahip Kotlin Multiplatform haber uygulaması. Ağ ve veritabanı commonMain'de.",
    projPortfolio =
      "Kotlin ve Compose Multiplatform (web) ile yazılmış kişisel site. Responsive yerleşim, kaydırma animasyonları, ortak tasarım sistemi.",
    openRepo = "GitHub'da görüntüle",
    notesOverline = "Yazılar",
    notesTitle = "Teknik yazılar",
    note1 = "Android'de local-first / offline-first mimari — Room, Flow, WorkManager",
    note2 = "Modern Android'de WorkManager: mimari standartlar ve uygulama",
    noteMoreWhen = "Diğer",
    note3 = "Jetpack Compose'da tasarım kalıpları ve Medium'daki diğer yazılar",
    footerFocus = "Mimari, sunucu güdümlü arayüz ve mobil güvenlik üzerine production iş.",
  )

  private val skillGroups = listOf(
    SkillGroup("Languages", listOf("Kotlin", "Java", "C#", "SQL")),
    SkillGroup("Android & KMP", listOf("Jetpack Compose", "CMP", "KMP", "Coroutines", "Flow", "Room", "Retrofit", "Hilt", "Koin")),
    SkillGroup("Architecture", listOf("Clean Architecture", "MVI", "MVVM", "Multi-module", "SDUI")),
    SkillGroup("Security", listOf("mTLS/TLS", "Certificate pinning", "Biometrics", "NFC", "OCR", "Liveness")),
    SkillGroup("CI/CD & tests", listOf("Jenkins", "Gradle", "JUnit", "Espresso", "Mockito", "Firebase")),
  )

  fun contentFor(language: AppLanguage): PortfolioContent {
    val copy = when (language) {
      AppLanguage.EN -> englishCopy
      AppLanguage.TR -> turkishCopy
    }
    val localizedSkillGroups = skillGroups.mapIndexed { index, group ->
      val title = when (index) {
        0 -> copy.stackLang
        1 -> copy.stackAndroid
        2 -> copy.stackArch
        3 -> copy.stackSec
        4 -> copy.stackCi
        else -> group.title
      }
      group.copy(title = title)
    }
  return PortfolioContent(
    copy = copy,
    skillGroups = localizedSkillGroups,
    productionProjects = listOf(
      ProjectItem("01", "Garanti BBVA Mobile", copy.app1, Links.GarantiPlay, copy.openPlay),
      ProjectItem("02", "Migros İK", copy.app2, Links.MigrosPlay, copy.openPlay),
      ProjectItem("03", "Hürriyet", copy.app3, Links.HurriyetPlay, copy.openPlay),
      ProjectItem("04", "Havaş Mobile", copy.app4, Links.HavasPlay, copy.openPlay),
      ProjectItem("05", "Renault PORT", copy.app5, Links.RenaultPlay, copy.openPlay),
      ProjectItem("06", "İŞMER İntranet", copy.app6, Links.IsmerPlay, copy.openPlay),
    ),
    personalProjects = listOf(
      ProjectItem(
        index = "07",
        title = "Spotter",
        description = copy.projSpotter,
        url = Links.SpotterRepo,
        linkLabel = copy.openRepo,
        tags = listOf("Kotlin", "Compose Multiplatform", "Material 3", "KMP"),
      ),
      ProjectItem(
        index = "08",
        title = "KMPNews",
        description = copy.projNews,
        url = Links.KmpNewsRepo,
        linkLabel = copy.openRepo,
        tags = listOf("Kotlin", "Kotlin Multiplatform", "Coroutines", "Clean Architecture"),
      ),
      ProjectItem(
        index = "09",
        title = "CMP (WEB)",
        description = copy.projPortfolio,
        url = Links.PortfolioRepo,
        linkLabel = copy.openRepo,
        tags = listOf("Kotlin", "Compose Multiplatform", "WASM", "Gradle"),
      ),
    ),
    notes = listOf(
      NoteItem("2026", copy.note1, Links.Note1),
      NoteItem("2026", copy.note2, Links.Note2),
      NoteItem(copy.noteMoreWhen, copy.note3, Links.Note3),
    ),
    github = githubShowcase(language),
  )
  }

  private fun githubShowcase(language: AppLanguage): GitHubShowcase {
    val localized = when (language) {
      AppLanguage.EN -> GitHubShowcaseCopy(
        title = "More on GitHub",
        badge = "Public repositories",
        description = "KMP/CMP apps, Android samples, and personal project repos.",
        cta = "Open GitHub",
      )
      AppLanguage.TR -> GitHubShowcaseCopy(
        title = "GitHub'da daha fazlası",
        badge = "Açık repolar",
        description = "KMP/CMP uygulamaları, Android örnekleri ve kişisel proje repoları.",
        cta = "GitHub'ı aç",
      )
    }
    return GitHubShowcase(
      title = localized.title,
      badge = localized.badge,
      description = localized.description,
      cta = localized.cta,
      tags = listOf("Kotlin", "Compose Multiplatform", "KMP", "Gradle", "Android"),
      url = Links.GitHub,
    )
  }

  private data class GitHubShowcaseCopy(
    val title: String,
    val badge: String,
    val description: String,
    val cta: String,
  )
}
