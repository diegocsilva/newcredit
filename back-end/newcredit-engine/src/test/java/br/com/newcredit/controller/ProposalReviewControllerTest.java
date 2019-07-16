package br.com.newcredit.controller;

import br.com.newcredit.domain.MarginCredit;
import br.com.newcredit.domain.MaritalStatus;
import br.com.newcredit.domain.Sex;
import br.com.newcredit.domain.Status;
import br.com.newcredit.dto.ProposalDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
@EnableAutoConfiguration
public class ProposalReviewControllerTest {
    private final ObjectMapper mapper = new ObjectMapper();
    private static String URL_NEW_CREDIT_ENGINE = "/api/proposal-reviews";

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext ctx;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void when_income_is_less_than_1000_then_return_denied_status() throws Exception {
        ProposalDTO proposal = newProposalDTOIncomeLess();

        performPost(proposal)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(Status.DENIED.name()))
                .andExpect(jsonPath("$.descriptionResult").value(MarginCredit.RENDA_BAIXA.getDescription()));
    }

    @Test
    public void when_the_income_divided_by_the_number_of_dependents_is_less_than_100_then_returns_denied_status() throws Exception {
        ProposalDTO proposal = newProposalDTODependends();

        performPost(proposal)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(Status.DENIED.name()))
                .andExpect(jsonPath("$.descriptionResult")
                        .value(MarginCredit.REPROVADO_PELA_POLITICA_DE_CREDITO.getDescription()));
    }

    @Test
    public void when_the_client_has_income_below_3500_is_divorced_and_has_dependents_then_return_denied_status() throws Exception {
        ProposalDTO proposal = newProposalDTODivorced();

        performPost(proposal)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(Status.DENIED.name()))
                .andExpect(jsonPath("$.descriptionResult")
                        .value(MarginCredit.REPROVADO_PELA_POLITICA_DE_CREDITO.getDescription()));
    }

    @Test
    public void when_the_customer_has_income_below_1500_is_widowed_and_has_dependents_then_return_status_denied() throws Exception {
        ProposalDTO proposal = newProposalDTOWidow();

        performPost(proposal)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(Status.DENIED.name()))
                .andExpect(jsonPath("$.descriptionResult")
                        .value(MarginCredit.REPROVADO_PELA_POLITICA_DE_CREDITO.getDescription()));
    }

    private ProposalDTO newProposalDTOIncomeLess() {
        return ProposalDTO.builder()
                .age(17)
                .cpf("11111111111")
                .dependents(4)
                .income(999.0)
                .maritalStatus(MaritalStatus.SINGLE)
                .name("Joao Silva")
                .sex(Sex.MALE)
                .state("SC")
                .build();
    }

    private ProposalDTO newProposalDTODependends() {
        return ProposalDTO.builder()
                .age(17)
                .cpf("11111111111")
                .dependents(11)
                .income(1000.0)
                .maritalStatus(MaritalStatus.SINGLE)
                .name("Joao Silva")
                .sex(Sex.MALE)
                .state("SC")
                .build();
    }

    private ProposalDTO newProposalDTODivorced() {
        return ProposalDTO.builder()
                .age(40)
                .cpf("11111111111")
                .dependents(2)
                .income(2000.0)
                .maritalStatus(MaritalStatus.DIVORCED)
                .name("Joao Silva")
                .sex(Sex.FEMALE)
                .state("SC")
                .build();
    }

    private ProposalDTO newProposalDTOWidow() {
        return ProposalDTO.builder()
                .age(17)
                .cpf("11111111111")
                .dependents(11)
                .income(1000.0)
                .maritalStatus(MaritalStatus.SINGLE)
                .name("Joao Silva")
                .sex(Sex.MALE)
                .state("SC")
                .build();
    }

    private ResultActions performPost(Object obj) throws Exception {
        MockHttpServletRequestBuilder post = MockMvcRequestBuilders
                .post(URL_NEW_CREDIT_ENGINE)
                .contentType(APPLICATION_JSON)
                .content(mapper.writeValueAsString(obj));
        return mockMvc.perform(post);
    }
}
