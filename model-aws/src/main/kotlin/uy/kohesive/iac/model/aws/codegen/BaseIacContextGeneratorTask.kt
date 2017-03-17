package uy.kohesive.iac.model.aws.codegen

import com.amazonaws.codegen.emitters.CodeWriter
import com.amazonaws.codegen.emitters.FreemarkerGeneratorTask
import freemarker.template.Template
import java.io.Writer

class BaseIacContextGeneratorTask private constructor(writer: Writer, template: Template, data: Any)
    : FreemarkerGeneratorTask(writer, template, data) {

    companion object {
        fun create(outputDirectory: String, baseContextData: BaseContextData): BaseIacContextGeneratorTask {

            baseContextData.clients.sortBy { it.awsInterfaceClassName }
            baseContextData.contexts.sortBy { it.contextClassName }

            return BaseIacContextGeneratorTask(
                CodeWriter(
                    outputDirectory + "/" + BaseContextData.PackagePath,
                    "IacContext",
                    ".kt"
                ),
                TemplateDescriptor.BaseIacContext.load(),
                baseContextData
            )
        }
    }

}

class BaseContextData {

    companion object {
        val PackageName = "uy.kohesive.iac.model.aws"
        val PackagePath = PackageName.replace('.', '/')
    }

    val contextPackageName: String = PackageName
    val clients  = ArrayList<GeneratedClientInfo>()
    val contexts = ArrayList<GeneratedContextInfo>()
}

data class GeneratedContextInfo(
    val contextFieldName: String,
    val enabledClassName: String,
    val contextClassName: String
)
//data class

data class GeneratedClientInfo(
    val clientFieldName: String,
    val deferredClientClassName: String,
    val awsInterfaceClassName: String,
    val awsInterfaceClassFq: String
)