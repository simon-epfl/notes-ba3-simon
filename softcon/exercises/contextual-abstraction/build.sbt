name := "contextual-abstraction"
scalaVersion := "3.5.0"
libraryDependencies ++= Seq(
  "com.lihaoyi" %% "upickle" % "3.3.1",
  "org.scalacheck" %% "scalacheck" % "1.17.0" % Test
)
scalacOptions ++= Seq("-deprecation", "-feature", "-language:fewerBraces", "-Xfatal-warnings")

Test / testOptions += Tests.Argument(
  TestFrameworks.ScalaCheck,
  // "-maxSize",
  // "5",
  // "-minSuccessfulTests",
  // "33",
  "-workers",
  "1",
  // "-verbosity",
  // "1"
  )
