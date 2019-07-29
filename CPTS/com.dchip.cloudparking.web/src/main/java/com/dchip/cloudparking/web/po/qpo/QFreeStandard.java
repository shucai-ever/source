package com.dchip.cloudparking.web.po.qpo;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

import javax.annotation.Generated;

import com.dchip.cloudparking.web.model.po.FreeStandard;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;


/**
 * QFreeStandard is a Querydsl query type for FreeStandard
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFreeStandard extends EntityPathBase<FreeStandard> {

    private static final long serialVersionUID = -284283553L;

    public static final QFreeStandard freeStandard = new QFreeStandard("freeStandard");

    public final NumberPath<Integer> freeModelId = createNumber("freeModelId", Integer.class);

    public final NumberPath<Integer> freeTimeLength = createNumber("freeTimeLength", Integer.class);

    public final NumberPath<java.math.BigDecimal> hourCost = createNumber("hourCost", java.math.BigDecimal.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<java.math.BigDecimal> mostCost = createNumber("mostCost", java.math.BigDecimal.class);

    public QFreeStandard(String variable) {
        super(FreeStandard.class, forVariable(variable));
    }

    public QFreeStandard(Path<? extends FreeStandard> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFreeStandard(PathMetadata metadata) {
        super(FreeStandard.class, metadata);
    }

	public NumberPath<Integer> getFreeModelId() {
		return freeModelId;
	}

	public NumberPath<Integer> getFreeTimeLength() {
		return freeTimeLength;
	}

	public NumberPath<java.math.BigDecimal> getHourCost() {
		return hourCost;
	}

	public NumberPath<Integer> getId() {
		return id;
	}

	public NumberPath<java.math.BigDecimal> getMostCost() {
		return mostCost;
	}

}

