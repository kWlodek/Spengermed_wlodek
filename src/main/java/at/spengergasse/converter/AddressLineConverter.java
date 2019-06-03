package at.spengergasse.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.util.Set;

@Converter
public class AddressLineConverter implements AttributeConverter<Set<String>, String> {

    private final static ObjectMapper objectMapper = new ObjectMapper();
    static {
        objectMapper.registerModule(new JavaTimeModule());
    }
    
    
    public String convertToDatabaseColumn(Set<String> Set) {
        if (Set == null || Set.isEmpty()) {
            return "";
        } else {
            try {
                return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(Set);
            } catch (JsonProcessingException ex) {
                throw new IllegalArgumentException("Set<String> not convertible" + Set);
            }
        }
    }

    
    public Set<String> convertToEntityAttribute(String joined) {        
        if (joined == null) {
            return null;
        }
        try {            
            return objectMapper.readValue(joined, new com.fasterxml.jackson.core.type.TypeReference<Set<String>>() {});
        } catch (IOException ex) {
            return null;
        }
    }

}

