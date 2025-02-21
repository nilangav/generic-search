package org.example.search.service

import org.example.search.query.QueryCriteria
import org.example.search.repository.GenericRepository
import org.example.search.request.GenericRequest
import org.jooq.SelectQuery
import org.jooq.impl.TableImpl
import org.jooq.impl.TableRecordImpl

class Search<R : TableRecordImpl<R>, T : TableImpl<R>>(
    private val repository: GenericRepository<R, T>,
) {
    fun selectQuery(request: GenericRequest): SelectQuery<R> = repository.select(buildCriteria(request))

    private fun buildCriteria(request: GenericRequest) =
        QueryCriteria
            .builder()
            .offset(request.startRow)
            .limit(request.startRow, request.endRow)
            .build()
}
