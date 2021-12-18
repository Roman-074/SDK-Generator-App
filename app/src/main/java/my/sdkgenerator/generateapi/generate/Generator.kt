package my.sdkgenerator.generateapi.generate

import com.squareup.kotlinpoet.*

open class Generator {

    fun restGetModel(){

        val builder =  FileSpec.builder("generate", "RestGetModel")
        val classBuilder = TypeSpec.classBuilder("User").addModifiers(KModifier.DATA)

        val ctor = FunSpec.constructorBuilder()
        ctor.addParameter("id", Int::class)
        classBuilder.primaryConstructor(ctor.build())

        val idProperty = PropertySpec.builder("id", Int::class).initializer("id").build()
        classBuilder.addProperty(idProperty)

        builder.addType(classBuilder.build())
        builder.build().writeTo(System.out)

    }


    fun mapperGenerator(){

    }



}