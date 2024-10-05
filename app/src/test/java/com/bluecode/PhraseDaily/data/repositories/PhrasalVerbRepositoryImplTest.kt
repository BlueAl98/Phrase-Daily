package com.bluecode.PhraseDaily.data.repositories

import com.bluecode.PhraseDaily.data.local.dao.PhrasalVerbDao
import com.bluecode.PhraseDaily.data.local.entities.PhrasalVerbsEntity
import com.bluecode.PhraseDaily.data.model.PhrasalVerbDto
import com.bluecode.PhraseDaily.data.network.Api
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class PhrasalVerbRepositoryImplTest{

    private lateinit var repository: PhrasalVerbRepositoryImpl
    private lateinit var api: Api
    private lateinit var phrasalVerbDao: PhrasalVerbDao

    @Before
    fun setUp() {
        api = mockk()
        phrasalVerbDao = mockk()
        repository = PhrasalVerbRepositoryImpl(api, phrasalVerbDao)

    }

    @Test
    fun `test getPhrasalVerbs returns list of phrasal verbs`() = runTest {
        val expectedPhrasalVerbs = listOf(
            PhrasalVerbsEntity(1, "give up", "rendirse")
        )
        coEvery { phrasalVerbDao.getPhrasalVerbs() } returns expectedPhrasalVerbs

        // Act
        val actualPhrasalVerbs = repository.getPhrasalVerbs().toList()

        // Assert
        assertEquals(expectedPhrasalVerbs.map { it.toDomain() }, actualPhrasalVerbs[0])
    }

    @Test
    fun `test saveVerbsInDatabase saves verbs from API to the database`() = runTest {
        // Arrange
        val verbsFromApi = listOf(
            PhrasalVerbDto("give up", "rendirse")
        )
        coEvery { api.getPhrasalVerbs() } returns verbsFromApi

        // Mock the insertPhrasalVerb method to do nothing (as it's usually a Unit return type)
        coEvery { phrasalVerbDao.insertPhrasalVerb(any()) } returns Unit

        // Act
        repository.saveVerbsInDatabase()

        // Assert
        coVerify(exactly = verbsFromApi.size) { phrasalVerbDao.insertPhrasalVerb(any()) }
    }



}