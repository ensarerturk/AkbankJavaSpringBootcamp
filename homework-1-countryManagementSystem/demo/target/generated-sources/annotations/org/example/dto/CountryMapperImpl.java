package org.example.dto;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.example.entity.Country;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-13T01:47:02+0300",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class CountryMapperImpl implements CountryMapper {

    @Override
    public CountryDTO map(Country country) {
        if ( country == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String capital = null;
        String currency = null;

        id = country.getId();
        name = country.getName();
        capital = country.getCapital();
        currency = country.getCurrency();

        CountryDTO countryDTO = new CountryDTO( id, name, capital, currency );

        return countryDTO;
    }

    @Override
    public List<CountryDTO> map(List<Country> countries) {
        if ( countries == null ) {
            return null;
        }

        List<CountryDTO> list = new ArrayList<CountryDTO>( countries.size() );
        for ( Country country : countries ) {
            list.add( map( country ) );
        }

        return list;
    }
}
