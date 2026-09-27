package in.bloomington.incident.model;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class AddressConverter implements AttributeConverter<String, Integer> {

		@Override
		public Integer convertToDatabaseColumn(String attribute) {
				Integer ret = null;
				try{
						ret = new Integer(attribute);
				}catch(Exception ex){
						System.err.println("invalid int ");
				}
				return ret;
				
		}
		
		@Override
		public String convertToEntityAttribute(Integer dbData) {
				return dbData.toString();
		}


}
