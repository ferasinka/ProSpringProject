package rules

import com.ferasinka.prospringproject.ch14.Rule
import com.ferasinka.prospringproject.ch14.RuleFactory
import org.joda.time.DateTime
import org.joda.time.Years
import org.springframework.stereotype.Component

@Component
class RuleFactoryImpl implements RuleFactory {
    Closure age = {
        birthDate ->
            return Years.yearsBetween(birthDate, new DateTime()).getYears()
    }

    @Override
    Rule getAgeCategoryRule() {
        Rule rule = new Rule()

        rule.singlehit = true

        rule.conditions = [
                { object, param -> age(object.birthDate) >= param },
                { object, param -> age(object.birthDate) <= param }
        ]

        rule.actions = [
                { object, param -> object.ageCategory = param }
        ]

        rule.parameters = [
                [0, 10, 'Kid'],
                [11, 20, 'Youth'],
                [21, 40, 'Adult'],
                [41, 60, 'Middle-aged'],
                [61, 120, 'Old']
        ]

        return rule
    }
}
