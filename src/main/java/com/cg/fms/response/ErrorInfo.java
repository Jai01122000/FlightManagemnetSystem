package com.cg.fms.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ErrorInfo {

	private LocalDateTime timestamp;
	private String status;
	private String error;
	private String path;

		
}
