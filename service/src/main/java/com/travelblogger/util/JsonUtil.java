package com.travelblogger.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.persistence.Tuple;
import javax.persistence.TupleElement;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {
    public static List<ObjectNode> _toJson(List<Tuple> results) {

        List<ObjectNode> json = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();

        for (Tuple t : results)
        {
            List<TupleElement<?>> cols = t.getElements();

            ObjectNode one = mapper.createObjectNode();

            for (TupleElement col : cols)
            {
                one.put(col.getAlias(), t.get(col.getAlias()).toString());
            }

            json.add(one);
        }

        return json;
    }
}
