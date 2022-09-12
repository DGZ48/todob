package xyz.dgz48.todob.springframework;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import xyz.dgz48.todob.data.entity.TaskEntity;
import xyz.dgz48.todob.service.task.Task;
import xyz.dgz48.todob.service.task.TaskRequest;

@Configuration
class ModelMapperConfiguration {

    @Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();

		// --------------------------------------------------------------------------------
		//  Mapping definitions.
		// --------------------------------------------------------------------------------
		configureMappingProductCategory(modelMapper);

		// validate rule
		modelMapper.validate();

		return modelMapper;
	}

	private void configureMappingProductCategory(ModelMapper modelMapper) {
		modelMapper.typeMap(TaskEntity.class, Task.class)
				.addMappings(mapper -> mapper.using(LDT2ZDT).map(TaskEntity::getCreatedDate, Task::setCreatedDate))
				.addMappings(mapper -> mapper.using(LDT2ZDT).map(TaskEntity::getLastModifiedDate, Task::setLastModifiedDate))
		;
		modelMapper.typeMap(TaskRequest.class, TaskEntity.class)
				.addMappings(mapper -> mapper.skip(TaskEntity::setCreatedDate))
				.addMappings(mapper -> mapper.skip(TaskEntity::setLastModifiedDate))
		;
	}

	static Converter<LocalDateTime, ZonedDateTime> LDT2ZDT = new AbstractConverter<LocalDateTime,ZonedDateTime>() {

		@Override
		protected ZonedDateTime convert(LocalDateTime source) {
			return source.atZone(ZoneId.systemDefault());
		}

	};
}
