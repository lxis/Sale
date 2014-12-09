package com.sage.sale.domain.services.questionnaires;

import com.sage.sale.domain.services.categories.*;
<<<<<<< HEAD
import com.sage.sale.domain.services.categories.beauty.MianMo;
import com.sage.sale.domain.services.categories.electric.Phone;
import com.sage.sale.domain.services.categories.electric.Tablet;
import com.sage.sale.domain.services.questionnaires.beauty.MianMoQuestionnaire;
=======
import com.sage.sale.domain.services.categories.electric.Phone;
import com.sage.sale.domain.services.categories.electric.Tablet;
>>>>>>> origin/master
import com.sage.sale.domain.services.questionnaires.electric.PhoneQuestionnaire;
import com.sage.sale.domain.services.questionnaires.electric.TabletQuestionnaire;

public class QuestionnaireFactory {
	
	public IQuestionnaire getQuestionnaire(Category category)
	{
		if(category instanceof MianMo)
			return new MianMoQuestionnaire();
		throw new RuntimeException();
	}

}
