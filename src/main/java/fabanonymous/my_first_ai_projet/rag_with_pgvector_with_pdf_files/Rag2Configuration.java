package fabanonymous.my_first_ai_projet.rag_with_pgvector_with_pdf_files;

import io.micrometer.observation.ObservationRegistry;
import org.springframework.ai.autoconfigure.vectorstore.pgvector.PgVectorStoreProperties;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.embedding.BatchingStrategy;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiEmbeddingModel;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.vectorstore.observation.VectorStoreObservationConvention;
import org.springframework.ai.vectorstore.pgvector.PgVectorStore;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class Rag2Configuration {

    @Bean(name="ChatClientForRag2")
    public ChatClient openAiChatClient(OpenAiChatModel chatModel, VectorStore vectorStore) {
        return ChatClient.builder(chatModel)
                .defaultAdvisors(new QuestionAnswerAdvisor(vectorStore))
                .build();
    }

    @Bean
    public PgVectorStore vectorStore(JdbcTemplate jdbcTemplate, OpenAiEmbeddingModel embeddingModel, PgVectorStoreProperties properties, ObjectProvider<ObservationRegistry> observationRegistry, ObjectProvider<VectorStoreObservationConvention> customObservationConvention, BatchingStrategy batchingStrategy) {
        boolean initializeSchema = properties.isInitializeSchema();
        return ((PgVectorStore.PgVectorStoreBuilder) ((PgVectorStore.PgVectorStoreBuilder) PgVectorStore.builder(jdbcTemplate, embeddingModel).schemaName(properties.getSchemaName()).vectorTableName(properties.getTableName()).vectorTableValidationsEnabled(properties.isSchemaValidation()).dimensions(properties.getDimensions()).distanceType(properties.getDistanceType()).removeExistingVectorStoreTable(properties.isRemoveExistingVectorStoreTable()).indexType(properties.getIndexType()).initializeSchema(initializeSchema).observationRegistry((ObservationRegistry) observationRegistry.getIfUnique(() -> ObservationRegistry.NOOP))).customObservationConvention((VectorStoreObservationConvention) customObservationConvention.getIfAvailable(() -> null))).batchingStrategy(batchingStrategy).maxDocumentBatchSize(properties.getMaxDocumentBatchSize()).build();
    }

}
