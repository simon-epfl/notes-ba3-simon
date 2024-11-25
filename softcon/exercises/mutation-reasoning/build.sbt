name := "statereasoning"
scalaVersion := "3.5.0"
libraryDependencies += "org.scalameta" %% "munit" % "1.0.1" % Test
scalacOptions ++= Seq("-deprecation", "-feature", "-language:fewerBraces", "-Xfatal-warnings")
