package com.ecommerce.utility

object IcebergSparkConfig {
  def apply(config: com.typesafe.config.Config): Map[String, String] = Map(
    "spark.jars.packages" -> "org.apache.iceberg:iceberg-spark-runtime-3.5_2.12:1.9.1",
    "spark.sql.extensions" -> "org.apache.iceberg.spark.extensions.IcebergSparkSessionExtensions",
    "spark.sql.catalog.spark_catalog" -> "org.apache.iceberg.spark.SparkSessionCatalog",
    "spark.sql.catalog.spark_catalog.type" -> "hive",
    "spark.sql.catalog.local" -> "org.apache.iceberg.spark.SparkCatalog",
    "spark.sql.catalog.local.type" -> "hadoop",
    "spark.sql.catalog.local.warehouse" -> config.getString("Ecommerce.Iceberg.warehouse"),
    "spark.sql.defaultCatalog" -> "local"
  )

}
