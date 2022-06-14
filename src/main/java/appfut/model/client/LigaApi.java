package appfut.model.client;

import appfut.model.Liga;

public interface LigaApi {

    void postLiga(Liga liga);

    void updateLiga(int id, Liga liga);
}
