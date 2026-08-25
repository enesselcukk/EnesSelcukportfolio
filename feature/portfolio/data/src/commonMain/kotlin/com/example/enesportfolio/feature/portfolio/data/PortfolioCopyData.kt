package com.example.enesportfolio.feature.portfolio.data

import com.example.enesportfolio.core.model.AppLanguage
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
      "I bring 5+ years of experience delivering production Android applications and secure banking SDKs with Kotlin and Java. Jetpack Compose has been part of my day-to-day work at Garanti BBVA; I have also contributed to Migros İK, Hürriyet, and Havaş. I am professionally engaged in Kotlin Multiplatform, with Compose Multiplatform explored through personal projects.",
    downloadCv = "Download CV",
    portraitCaption = "İstanbul, Türkiye",
    aboutTitle = "Expertise",
    aboutBody =
      "My focus spans MVI/MVVM architecture, server-driven UI (SDUI), mobile security (mTLS, biometrics, KYC/NFC), and multi-module design. For the applications I deliver, I also own CI/CD pipelines and unit and UI testing end to end.",
    nowLabel = "Current focus",
    nowOne = "Spotter — shared UI across platforms with Compose Multiplatform (personal project)",
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
    j1e = "Implemented mTLS, certificate pinning, and secure token authentication for app-to-app banking. The first security audit returned zero critical findings.",
    j1f = "Wrote 50+ unit and Compose UI tests and set up Jenkins CI/CD. Coverage reached 80%; pipeline time dropped from 38 minutes to 14.",
    j2When = "Jun 2022 – Oct 2023",
    j2Role = "Android Developer",
    j2a = "Maintained and improved Android apps for Migros İK, Hürriyet, Havaş, OYAK, and Avivasa, serving 500K+ / 1M+ active users. Crash-free rate improved from 98.5% to 99.4%.",
    j2b = "Refactored legacy Java/Kotlin to MVVM with Coroutines and Flow. Removed 50+ obsolete modules and reduced build time by 25%.",
    j2c = "Managed end-to-end production releases on Google Play and Huawei AppGallery (HMS).",
    j3When = "Jul 2020 – Apr 2022",
    j3Company = "Osmaniye Korkut Ata University — IT Department",
    j3Role = "Part-time Android Developer",
    j3a = "Built the official university app with Kotlin, MVVM, and Firebase, including authentication and a campus news feed.",
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
    openPlay = "View on Google Play",
    persOverline = "Personal",
    persTitle = "KMP / CMP",
    projSpotter = "Compose Multiplatform application with a shared UI across platforms.",
    projNews = "Kotlin Multiplatform news application with a shared business-logic and data layer.",
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
      "Beş yılı aşkın profesyonel deneyimle Kotlin ve Java kullanarak production Android uygulamaları ve secure banking SDK'ları geliştiriyorum. Jetpack Compose'u günlük iş akışımda yalnızca Garanti BBVA kapsamında aktif olarak kullandım; Migros İK, Hürriyet ve Havaş uygulamalarında da geliştirme süreçlerine katkı sağladım. Kotlin Multiplatform alanıyla profesyonel olarak ilgileniyorum; Compose Multiplatform çalışmalarım kişisel projelerimde ilerliyor.",
    downloadCv = "CV'yi indir",
    portraitCaption = "İstanbul, Türkiye",
    aboutTitle = "Uzmanlık",
    aboutBody =
      "MVI/MVVM, Server-Driven UI (SDUI), mobile security (mTLS, biometrics, KYC/NFC) ve multi-module design üzerinde çalışıyorum. Teslim ettiğim uygulamalarda CI/CD pipeline kurulumu ile unit ve UI test süreçlerini uçtan uca yönetiyorum.",
    nowLabel = "Güncel odak",
    nowOne = "Spotter — Compose Multiplatform ile shared UI (kişisel proje)",
    nowTwo = "KMPNews — Kotlin Multiplatform ile shared business logic ve data layer (kişisel proje)",
    nowThree = "Medium'da Android architecture ve engineering practices üzerine teknik yazılar",
    expOverline = "Deneyim",
    expTitle = "Profesyonel deneyim",
    j1When = "Ekim 2023 – Nisan 2026",
    j1Role = "Senior / Mid Android Developer · Garanti BBVA (contractor)",
    j1a = "Jetpack Compose ve MVI ile 10'dan fazla ekranı kapsayan modüler bir SDUI SDK geliştirdim. UI, app store release olmadan backend üzerinden güncellenebiliyor.",
    j1b = "Individual ve corporate banking flow'ları için Manual DI tabanlı Login SDK ve Approve SDK geliştirdim.",
    j1c = "NFC ID scan, OCR ve liveness kontrolü içeren KYC SDK'ları geliştirdim. Onboarding süresini 8 dakikadan 3 dakikaya indirdim; verification success rate %92'ye ulaştı.",
    j1d = "Third-party library üzerine Server Push SDK geliştirdim; vendor documentation okuyarak entegrasyonu uçtan uca implement ettim.",
    j1e = "App-to-app banking için mTLS, certificate pinning ve secure token authentication uyguladım. İlk security audit'te critical finding çıkmadı.",
    j1f = "50'den fazla unit ve Compose UI testi yazdım; Jenkins ile CI/CD pipeline kurdum. Test coverage %80'e çıktı, pipeline süresi 38 dakikadan 14 dakikaya düştü.",
    j2When = "Haziran 2022 – Ekim 2023",
    j2Role = "Android Developer",
    j2a = "Migros İK, Hürriyet, Havaş, OYAK ve Avivasa uygulamalarının bakımını ve geliştirmesini yürüttüm. Uygulamalar 500 bin / 1 milyon üzeri aktif kullanıcıya hizmet veriyor; çökmesiz çalışma oranı %98,5'ten %99,4'e yükseldi.",
    j2b = "Eski Java/Kotlin kod tabanını Coroutines ve Flow ile MVVM mimarisine taşıdım. 50'den fazla kullanılmayan modül kaldırıldı; derleme süresi %25 kısaldı.",
    j2c = "Google Play ve Huawei AppGallery (HMS) üzerinde uçtan uca üretim yayınlarını yönettim.",
    j3When = "Temmuz 2020 – Nisan 2022",
    j3Company = "Osmaniye Korkut Ata Üniversitesi — Bilgi İşlem",
    j3Role = "Yarı zamanlı Android Developer",
    j3a = "Kotlin, MVVM ve Firebase ile üniversitenin resmi mobil uygulamasını geliştirdim; kimlik doğrulama ve kampüs haber akışını ekledim.",
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
    app1 = "Banking SDK'ları: SDUI, Login, Approve, KYC ve Server Push.",
    app2 = "Çalışan portalı ve QR kimlik doğrulama.",
    app3 = "Yüksek trafikli haber ve medya uygulaması.",
    app4 = "Kurumsal ulaşım ve lojistik platformu.",
    app5 = "Otomotiv müşteri portalı.",
    openPlay = "Google Play'de görüntüle",
    persOverline = "Kişisel",
    persTitle = "KMP / CMP",
    projSpotter = "Compose Multiplatform uygulaması; platformlar arasında paylaşılan arayüz.",
    projNews = "Kotlin Multiplatform haber uygulaması; paylaşılan iş kuralı ve veri katmanı.",
    openRepo = "GitHub'da görüntüle",
    notesOverline = "Yazılar",
    notesTitle = "Teknik yazılar",
    note1 = "Android'de local-first / offline-first mimari — Room, Flow, WorkManager",
    note2 = "Modern Android'de WorkManager: mimari standartlar ve uygulama",
    noteMoreWhen = "Diğer",
    note3 = "Jetpack Compose'da tasarım kalıpları ve Medium'daki diğer yazılar",
    footerFocus = "Architecture, Server-Driven UI ve mobile security odaklı production deneyimi.",
  )

  private val skillGroups = listOf(
    SkillGroup("Languages", listOf("Kotlin", "Java", "C#", "SQL")),
    SkillGroup("Android & KMP", listOf("Jetpack Compose", "CMP", "KMP", "Coroutines", "Flow", "Room", "Retrofit", "Hilt", "Koin")),
    SkillGroup("Architecture", listOf("Clean Architecture", "MVI", "MVVM", "Multi-module", "SDUI")),
    SkillGroup("Security", listOf("mTLS", "Certificate pinning", "Biometrics", "NFC", "OCR", "Liveness")),
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
    ),
    personalProjects = listOf(
      ProjectItem("06", "Spotter", copy.projSpotter, Links.SpotterRepo, copy.openRepo),
      ProjectItem("07", "KMPNews", copy.projNews, Links.KmpNewsRepo, copy.openRepo),
    ),
    notes = listOf(
      NoteItem("2026", copy.note1, Links.Note1),
      NoteItem("2026", copy.note2, Links.Note2),
      NoteItem(copy.noteMoreWhen, copy.note3, Links.Note3),
    ),
  )
  }
}
