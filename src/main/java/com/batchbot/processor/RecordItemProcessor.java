package com.batchbot.processor;

import com.batchbot.dbo.CaseDBO;
import com.batchbot.dto.CaseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class RecordItemProcessor implements ItemProcessor<CaseDTO, CaseDBO> {

    private static final Logger log = LoggerFactory.getLogger(ItemProcessor.class);

    @Override
    public CaseDBO process(final CaseDTO dto) throws Exception {
        CaseDBO dbo = new CaseDBO();
        dbo.setFirstName(dto.getFirstName());
        dbo.setLastName(dto.getLastName());
        dbo.setEyeColor(dto.getEyeColor());
        dbo.setHairColor(dto.getHairColor());
        return dbo;
    }
}
