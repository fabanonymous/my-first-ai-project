package fabanonymous.my_first_ai_projet.rag_with_pgvector_with_pdf_files;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Rag2Configuration {

    @Bean(name="ChatClientForRag2")
    public ChatClient chatClient(ChatClient.Builder builder, VectorStore vectorStore) {
        System.out.println("Rag2Configuration.openAiChatClient ################################################################");
        return builder
                .defaultAdvisors(new QuestionAnswerAdvisor(vectorStore))
                .build();
    }

    /*
    @Bean ChatClient.Builder chatClientBuilder(OpenAiChatModel chatModel) {
        System.out.println("Rag2Configuration.chatClientBuilder ################################################################");
        return ChatClient.builder(chatModel);
    }
    */

    /*
    @Bean(name="ChatClientForRag2")
    public ChatClient openAiChatClient(OpenAiChatModel chatModel, VectorStore vectorStore) {
        System.out.println("Rag2Configuration.openAiChatClient ################################################################");
        return ChatClient.builder(chatModel)
                .defaultAdvisors(new QuestionAnswerAdvisor(vectorStore))
                .build();
    }
    */

    /*
    @Bean
    public PgVectorStore vectorStore(JdbcTemplate jdbcTemplate, OpenAiEmbeddingModel embeddingModel, PgVectorStoreProperties properties, ObjectProvider<ObservationRegistry> observationRegistry, ObjectProvider<VectorStoreObservationConvention> customObservationConvention, BatchingStrategy batchingStrategy) {
        System.out.println("Rag2Configuration.vectorStore ################################################################");
        boolean initializeSchema = properties.isInitializeSchema();
        return ((PgVectorStore.PgVectorStoreBuilder) ((PgVectorStore.PgVectorStoreBuilder) PgVectorStore.builder(jdbcTemplate, embeddingModel).schemaName(properties.getSchemaName()).vectorTableName(properties.getTableName()).vectorTableValidationsEnabled(properties.isSchemaValidation()).dimensions(properties.getDimensions()).distanceType(properties.getDistanceType()).removeExistingVectorStoreTable(properties.isRemoveExistingVectorStoreTable()).indexType(properties.getIndexType()).initializeSchema(initializeSchema).observationRegistry((ObservationRegistry) observationRegistry.getIfUnique(() -> ObservationRegistry.NOOP))).customObservationConvention((VectorStoreObservationConvention) customObservationConvention.getIfAvailable(() -> null))).batchingStrategy(batchingStrategy).maxDocumentBatchSize(properties.getMaxDocumentBatchSize()).build();
    }
    */
}
