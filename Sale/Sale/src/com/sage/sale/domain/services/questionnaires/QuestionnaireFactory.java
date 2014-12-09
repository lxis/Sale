package com.sage.sale.domain.services.questionnaires;

import com.sage.sale.domain.services.categories.*;
import com.sage.sale.domain.services.categories.beauty.*;
import com.sage.sale.domain.services.questionnaires.beauty.*;

public class QuestionnaireFactory {
	
	public IQuestionnaire getQuestionnaire(Category category)
	{
		if(category instanceof MianMo)
			return new MianMoQuestionnaire();
		else if(category instanceof HuaZhuangShui)
			return new HuaZhuangShuiQuestionnaire();
		throw new RuntimeException();
	}

}
