// -*- mode: scala -*-
import mill._, scalalib._, publish._

val crossVersions = Seq("2.13.2")

object keybase extends Cross[Keybase](crossVersions: _*)
class Keybase(val crossScalaVersion: String) extends CrossScalaModule with PublishModule {
  def publishVersion = os.read(os.pwd / "VERSION").trim

  val zioVersion = "1.0.0-RC20"

  override def ivyDeps = Agg(
    ivy"com.lihaoyi::os-lib:0.6.3",
    ivy"com.lihaoyi::upickle::1.1.0",
    ivy"dev.zio::zio:${zioVersion}",
    ivy"dev.zio::zio-streams:${zioVersion}"
  )

  def artifactName = "keybase-scala-bot"

  def pomSettings = PomSettings(
    description = "An small library for creating keybase bots using scala.",
    organization = "com.github.vic",
    url = "https://github.com/vic/keybase-scala-bot",
    licenses = Seq(License.`Apache-2.0`),
    versionControl = VersionControl.github("vic", "keybase-scala-bot"),
    developers = Seq(
      Developer("vic", "Victor Borja", "https://github.com/vic")
    )
  )

}
