name := "dbdemo2"

version := "1.0"

lazy val `dbdemo2` = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq( javaJdbc ,  cache , javaWs
//  "com.oracle.jdbc" % "ojdbc7" % "12.1.0.2"
)


//libraryDependencies ++= Seq(
//  "com.oracle.jdbc" % "ojdbc7" % "12.1.0.2"
//)


unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"  