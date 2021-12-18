package my.sdkgenerator.generateapi.parse

import com.beust.klaxon.Json

data class InputDataModel(

    @Json(name = "instance_version")
    val version: Int,

    @Json(name = "link_serial")
    val serial : Int,

    @Json(name = "snap_map")
    val snap_map: SnapModel,

    @Json(name = "target_runtime")
    val target_runtime : String

)


data class SnapModel(

    @Json(name = "snap")
    val mapper: String,

    @Json(name = "snap")
    val filter: String,

    @Json(name = "snap")
    val rest_get: String

)



data class ResultModel(
    val version: Int,
    val serial: Int,
    val target_runtime: String
)