package furhatos.app.fruitseller

import furhatos.app.fruitseller.flow.Init
import furhatos.flow.kotlin.Flow
import furhatos.skills.Skill

class FruitsellerSkill : Skill() {
    override fun start() {
        Flow().run(Init)
    }
}

fun main(args: Array<String>) {
    Skill.main(args)
}
