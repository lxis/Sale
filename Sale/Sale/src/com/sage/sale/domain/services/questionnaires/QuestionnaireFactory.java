package com.sage.sale.domain.services.questionnaires;

import com.sage.sale.domain.services.categories.*;
import com.sage.sale.domain.services.categories.electric.Phone;
import com.sage.sale.domain.services.categories.electric.Tablet;
import com.sage.sale.domain.services.questionnaires.electric.PhoneQuestionnaire;
import com.sage.sale.domain.services.questionnaires.electric.TabletQuestionnaire;

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
