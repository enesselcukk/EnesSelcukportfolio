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
    heroOverline = "Android · Compose · KMP",
    heroRole = "Android Developer",
    heroLede =
      "I have 5+ years of experience building production Android applications, secure banking SDKs, and cross-platform products with Kotlin, Jetpack Compose, KMP, and CMP — including projects for Garanti BBVA, Migros İK, Hürriyet, and Havaş.",
    downloadCv = "Download CV",
    portraitCaption = "İstanbul, Turkey",
    aboutTitle = "Expertise",
    aboutBody =
      "MVI/MVVM, server-driven UI, mobile security (mTLS, biometrics, KYC/NFC), and multi-module architecture. I also own CI/CD pipelines and unit/UI testing for the applications I deliver.",
    nowLabel = "Current",
    nowOne = "Spotter — Compose Multiplatform with shared UI",
    nowTwo = "KMPNews — shared business logic and data layer",
    nowThree = "Technical writing on Android architecture (Medium)",
    expOverline = "Experience",
    expTitle = "Professional experience",
    j1When = "Oct 2023 – Apr 2026",
    j1Role = "Senior / Mid Android Developer · Contractor at Garanti BBVA",
    j1a = "Built a modular SDUI SDK with Jetpack Compose and MVI covering 10+ screens, so the backend can update UI without an app-store release.",
    j1b = "Implemented mTLS, certificate pinning, and secure token authentication for app-to-app banking. The first security audit returned zero critical findings.",
    j1c = "Delivered KYC SDKs with NFC ID scanning, OCR, and liveness checks. Onboarding time fell from 8 minutes to 3; verification success reached 92%.",
    j1d = "Wrote 50+ unit and Compose UI tests and set up Jenkins CI/CD. Coverage reached 80%; pipeline time dropped from 38 minutes to 14.",
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
    eduDegree = "B.S. Management Information Systems",
    eduWhen = "2018 – 2022 · GPA 3.6 / 4.0",
    prodOverline = "Applications",
    prodTitle = "Selected applications",
    app1 = "Banking SDKs: SDUI, mTLS, KYC with OCR/NFC/biometrics, server push.",
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
    heroOverline = "Android · Compose · KMP",
    heroRole = "Android Developer",
    heroLede =
      "Beş yılı aşkın süredir Kotlin, Jetpack Compose, KMP ve CMP ile üretim Android uygulamaları, güvenli bankacılık SDK'ları ve çapraz platform ürünler geliştiriyorum. Garanti BBVA, Migros İK, Hürriyet ve Havaş uygulamalarında yer aldım.",
    downloadCv = "CV'yi indir",
    portraitCaption = "İstanbul, Türkiye",
    aboutTitle = "Uzmanlık",
    aboutBody =
      "MVI/MVVM, sunucu güdümlü arayüz (SDUI), mobil güvenlik (mTLS, biyometri, KYC/NFC) ve çok modüllü mimari. Teslim ettiğim uygulamalarda CI/CD hatları ile unit ve arayüz testlerinden de sorumluyum.",
    nowLabel = "Güncel",
    nowOne = "Spotter — Compose Multiplatform, paylaşılan arayüz",
    nowTwo = "KMPNews — paylaşılan iş kuralı ve veri katmanı",
    nowThree = "Medium'da Android mimarisi üzerine teknik yazılar",
    expOverline = "Deneyim",
    expTitle = "Profesyonel deneyim",
    j1When = "Ekim 2023 – Nisan 2026",
    j1Role = "Senior / Mid Android Developer · Garanti BBVA (contractor)",
    j1a = "Jetpack Compose ve MVI ile 10'dan fazla ekranı kapsayan modüler bir SDUI SDK geliştirdim. Arayüz, mağaza yayını olmadan backend üzerinden güncellenebiliyor.",
    j1b = "Uygulamalar arası bankacılık için mTLS, sertifika sabitleme ve güvenli token kimlik doğrulaması uyguladım. İlk güvenlik denetiminde kritik bulgu çıkmadı.",
    j1c = "NFC kimlik okuma, OCR ve liveness kontrolü içeren KYC SDK'ları geliştirdim. Onboarding süresini 8 dakikadan 3 dakikaya indirdim; doğrulama başarı oranı %92'ye ulaştı.",
    j1d = "50'den fazla unit ve Compose UI testi yazdım; Jenkins ile CI/CD hattını kurdum. Test kapsamı %80'e çıktı, pipeline süresi 38 dakikadan 14 dakikaya düştü.",
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
    eduDegree = "Yönetim Bilişim Sistemleri, Lisans",
    eduWhen = "2018 – 2022 · GANO 3.6 / 4.0",
    prodOverline = "Uygulamalar",
    prodTitle = "Çalıştığım uygulamalar",
    app1 = "Bankacılık SDK'ları: SDUI, mTLS, OCR/NFC/biyometri ile KYC ve sunucu bildirimi.",
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
    footerFocus = "Mimari, sunucu güdümlü arayüz ve mobil güvenlik odaklı üretim deneyimi.",
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
