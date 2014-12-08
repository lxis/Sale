package com.sage.sale.domain.services.questionnaires;

import com.sage.sale.domain.services.categories.*;

public class QuestionnaireFactory {
	
	public IQuestionnaire getQuestionnaire(Category category)
	{
		if(category instanceof Phone)
			return new PhoneQuestionnaire();
		else if(category instanceof Tablet) 
			return new TabletQuestionnaire();
		throw new RuntimeException();
	}

}
