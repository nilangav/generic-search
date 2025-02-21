package org.example.search.repository

import org.example.search.query.QueryCriteria
import org.jooq.*
import org.jooq.impl.TableImpl
import org.jooq.impl.TableRecordImpl

class GenericRepository<R : TableRecordImpl<R>, T : TableImpl<R>>(
    private val jooq: DSLContext,
    private val table: T,
) {
    fun select(criteria: QueryCriteria): SelectQuery<R> =
        jooq
            .selectQuery(table)
            .apply {
                if (criteria.valueColumns.isNotEmpty()) addSelect(criteria.valueColumns)
                if (criteria.filterModel.isNotEmpty()) addConditions(criteria.filterModel)
                if (criteria.sortModel.isNotEmpty()) addOrderBy(criteria.sortModel)
                addLimit(criteria.limit)
                addOffset(criteria.offset)
            }
}
