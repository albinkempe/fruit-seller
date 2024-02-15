package furhatos.app.fruitseller.flow.main

import furhatos.app.fruitseller.flow.Options
import furhatos.app.fruitseller.nlu.FruitList
import furhatos.flow.kotlin.*
import furhatos.nlu.common.No

val TakingOrder = state(parent = Options) {
    onEntry {
        furhat.ask {
            random {
                +"How about some fruits?"
                +"Do you want some fruits?"
            }
        }
    }

    onResponse<No> {
        furhat.say("Okay, that's a shame. Have a splendid day!")
        goto(Idle)
    }
}

fun orderReceived(fruitList: FruitList) : State = state(Options) {
    onEntry {
        furhat.say("${fruitList.text}, what a lovely choice!")
        fruitList.list.forEach {
            users.current.order.fruits.list.add(it)
        }
        furhat.ask("Anything else?")
    }

    onReentry {
        furhat.ask("Did you want something else?")
    }

    onResponse<No> {
        furhat.say("Okay, here is your order of ${users.current.order.fruits}. Have a great day!")
        goto(Idle)
    }
}