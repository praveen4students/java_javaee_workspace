1. delimiter $

2. create procedure studentUpSert
	(IN input_regno INT,
	 IN input_fnm VARCHAR(50),
	 IN input_mnm VARCHAR(50),
	 IN input_lnm VARCHAR(50),
	 IN input_gfnm VARCHAR(50),
	 IN input_gmnm VARCHAR(50),
	 IN input_glnm VARCHAR(50),
	 IN input_isadmin VARCHAR(1),
	 IN input_pass VARCHAR(50)
	 )    
	begin
		declare regno_count int;
		
		select count(*) into regno_count 
		from students_info
		where regno = input_regno;
		
		if regno_count>0 then
		
			update students_info
			set firstname = input_fnm,
				middlename = input_mnm,
				lastname = input_lnm
			where regno = input_regno;
			
			update guardian_info
			set gfirstname = input_gfnm,
				gmiddlename = input_gmnm,
				glastname = input_glnm
			where regno = input_regno;
			
			update students_otherinfo
			set isadmin = input_isadmin,
				password = input_pass
			where regno = input_regno;
			
		else
			insert into students_info
			values (input_regno, 
					input_fnm, 
					input_mnm, 
					input_lnm);
					
			insert into guardian_info
			values (input_regno, 
					input_gfnm, 
					input_gmnm, 
					input_glnm);
					
			insert into students_otherinfo
			values (input_regno, 
					input_isadmin, 
					input_pass);
		end if;
	end$
	
3. delimiter ;

4. call studentUpSert (1, 'Praveen', 'NA', 'D', 'AAA', 'NA', 'BBB', 'Y', 'qwerty');
				 
				 
				 
				 
				 
				 
	