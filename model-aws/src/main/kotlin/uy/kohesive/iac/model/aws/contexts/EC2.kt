package uy.kohesive.iac.model.aws.contexts

import com.amazonaws.services.ec2.AmazonEC2
import com.amazonaws.services.ec2.model.AuthorizeSecurityGroupIngressRequest
import com.amazonaws.services.ec2.model.CreateSecurityGroupRequest
import uy.kohesive.iac.model.aws.IacContext
import uy.kohesive.iac.model.aws.KohesiveIdentifiable
import uy.kohesive.iac.model.aws.utils.DslScope

@DslScope
class EC2Context(private val context: IacContext): EC2Enabled by context {

    /**
     * @return Security group ID
     */
    fun EC2Context.createSecurityGroup(groupName: String, init: CreateSecurityGroupRequest.() -> Unit): String {
        return ec2Client.createSecurityGroup(CreateSecurityGroupRequest().apply {
            withGroupName(groupName)
            init(this)
        }).groupId
    }

    fun EC2Context.authorizeSecurityGroupIngress(groupName: String, init: AuthorizeSecurityGroupIngressRequest.() -> Unit) {
        ec2Client.authorizeSecurityGroupIngress(AuthorizeSecurityGroupIngressRequest().apply {
            withGroupName(groupName)
            init(this)
        })
    }

}