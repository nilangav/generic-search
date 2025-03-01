package org.example.search.filter

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import org.example.search.enum.FilterType
import org.example.search.request.filter.NumberColumnFilter
import org.jooq.impl.DSL

class NumberFilterConditionTest :
    ShouldSpec({

        val field = DSL.field("field")

        should("return eq condition when filterType is EQUALS") {
            // Arrange
            val numberColumnFilter = NumberColumnFilter(type = FilterType.EQUALS.value, filter = 1)
            val expected = field.eq(numberColumnFilter.filter)

            // Act & Assert
            NumberFilterCondition(numberColumnFilter).getDslCondition(field) shouldBe expected
        }

        should("return ne condition when filterType is NOT_EQUALS") {
            // Arrange
            val numberColumnFilter = NumberColumnFilter(type = FilterType.NOT_EQUALS.value, filter = 1)
            val expected = field.ne(numberColumnFilter.filter)

            // Act & Assert
            NumberFilterCondition(numberColumnFilter).getDslCondition(field) shouldBe expected
        }

        should("return gt condition when filterType is GREATER_THAN") {
            // Arrange
            val numberColumnFilter = NumberColumnFilter(type = FilterType.GREATER_THAN.value, filter = 1)
            val expected = field.gt(numberColumnFilter.filter)

            // Act & Assert
            NumberFilterCondition(numberColumnFilter).getDslCondition(field) shouldBe expected
        }

        should("return ge condition when filterType is GREATER_THAN_OR_EQUALS") {
            // Arrange
            val numberColumnFilter = NumberColumnFilter(type = FilterType.GREATER_THAN_OR_EQUALS.value, filter = 1)
            val expected = field.ge(numberColumnFilter.filter)

            // Act & Assert
            NumberFilterCondition(numberColumnFilter).getDslCondition(field) shouldBe expected
        }

        should("return lt condition when filterType is LESS_THAN") {
            // Arrange
            val numberColumnFilter = NumberColumnFilter(type = FilterType.LESS_THAN.value, filter = 1)
            val expected = field.lt(numberColumnFilter.filter)

            // Act & Assert
            NumberFilterCondition(numberColumnFilter).getDslCondition(field) shouldBe expected
        }

        should("return le condition when filterType is LESS_THAN_OR_EQUALS") {
            // Arrange
            val numberColumnFilter = NumberColumnFilter(type = FilterType.LESS_THAN_OR_EQUALS.value, filter = 1)
            val expected = field.le(numberColumnFilter.filter)

            // Act & Assert
            NumberFilterCondition(numberColumnFilter).getDslCondition(field) shouldBe expected
        }

        should("return between condition when filterType is IN_RANGE") {
            // Arrange
            val numberColumnFilter = NumberColumnFilter(type = FilterType.IN_RANGE.value, filter = 1, filterTo = 2)
            val expected = field.between(numberColumnFilter.filter, numberColumnFilter.filterTo)

            // Act & Assert
            NumberFilterCondition(numberColumnFilter).getDslCondition(field) shouldBe expected
        }

        should("throw an exception when filterType is invalid") {
            // Arrange
            val numberColumnFilter = NumberColumnFilter(type = "anything", filter = 1)

            // Act & Assert
            shouldThrow<IllegalArgumentException> { NumberFilterCondition(numberColumnFilter).getDslCondition(field) }
        }
    })
