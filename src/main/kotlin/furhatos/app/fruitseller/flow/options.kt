package furhatos.app.fruitseller.flow

import furhatos.app.fruitseller.flow.main.orderReceived
import furhatos.app.fruitseller.nlu.BuyFruit
import furhatos.app.fruitseller.nlu.Fruit
import furhatos.app.fruitseller.nlu.RequestOptions
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.onResponse
import furhatos.flow.kotlin.state
import furhatos.nlu.common.Yes
import furhatos.util.Language

val Options = state(Parent) {
    onResponse<BuyFruit> {
        val fruits = it.intent.fruits
        if (fruits != null) {
            goto(orderReceived(fruits))
        }
        else {
            propagate()
        }
    }

    onResponse<RequestOptions> {
        furhat.say("We have ${Fruit().getEnum(Language.ENGLISH_US).joinToString(", ")}")
        furhat.ask("Do you want some?")
    }

    onResponse<Yes> {
        furhat.ask {
            random {
                +"What kind of fruit do you want?"
                +"What type of fruit?"
            }
        }
    }
}