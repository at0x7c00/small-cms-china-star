package me.huqiao.smallcms.ppll.entity.propertyeditor;
import java.beans.PropertyEditorSupport;

import me.huqiao.smallcms.ppll.entity.Worker;
import me.huqiao.smallcms.ppll.service.IWorkerService;
/**
 * 工作人员编辑器
 * @author NOVOTS
 * @version Version 1.0
 */
public class WorkerEditor extends PropertyEditorSupport{
    public IWorkerService workerService;
    public WorkerEditor(IWorkerService workerService){
        this.workerService = workerService;
    }
    public String getAsText(){
        Worker worker = (Worker)getValue();
        if(worker==null){
            return "";
        }
        return String.valueOf(worker.getId());
    }
    public void setAsText(String key)throws IllegalArgumentException {
        Worker worker = null;
worker = workerService.getEntityByProperty(Worker.class,"manageKey",key);
if(worker==null){
            Integer integerId = null;
            try {integerId = Integer.parseInt(key);} catch (Exception e) {}
            worker = workerService.getById(Worker.class,integerId);
}
if(key!=null && !key.trim().equals("") && worker==null){
worker=new Worker();
}
        setValue(worker);
    }
}