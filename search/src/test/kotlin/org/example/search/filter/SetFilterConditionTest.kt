package org.example.search.filter

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import org.example.search.request.filter.SetColumnFilter
import org.jooq.impl.DSL

class SetFilterConditionTest :
    ShouldSpec({

        should("return in condition when filterType is IN_RANGE") {
            // Arrange
            val field = DSL.field("field")
            val setColumnFilter = SetColumnFilter(values = emptyList())

            // Act & Assert
            SetFilterCondition(setColumnFilter).getDslCondition(field) shouldBe field.`in`(setColumnFilter.values)
        }
    })
