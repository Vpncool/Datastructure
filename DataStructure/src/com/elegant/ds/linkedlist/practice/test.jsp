<div class="col-lg-120">
	<div class="analysis-padding-bot">
		<div class="repository-action-btn">

			<a class="btn btn-default btn-sm" title="Merge" href="#" onclick="javascript:mergeCondtion()">
				<i class="icon-enclose-parenthesis"></i> 
			</a> 
			<a class="btn btn-default btn-sm" title="Split" href="#" onclick="javascript:splitCondtion()">
				<i class="icon-remove-parenthesis"></i> 
			</a> 
			<a class="btn btn-default btn-sm" href="#" data-dismiss="modal" data-toggle="modal" data-target="#analysis-delete-confirmation-dialog" onclick="javascript:deleteConfirmDialog('removeAdminObject(9)')" title="Delete">
				<i class="icon-delete"></i> 
			</a>
		</div>
	</div>
</div>

<td>
	<input type="checkbox" onclick="showActionButton(this, 'adminRightPanel');" name="0" class="">
	<span class="lbl"></span>
</td>

<th width="40%">Column</th>
<th width="15%">Operators</th>
<th width="20%">Value</th>
<th width="15%">&nbsp;</th>
<th width="9%">&nbsp;</th>

<tr data-schemaname="dbo" data-tablename="sysdepends"
	data-typename="Integer" class="selected">
	<td>
		<input type="checkbox" onclick="showMergeSplitTooltip(this);"class="checked">
	</td>
	<td style="word-break: break-all;" data-sqlcolumnname="id">dbo.sysdepends.id</td>
	<td style="padding-left: 5px;" data-sqloperator="=">=</td>
	<td data-value="1961058022" data-value2="undefined">1961058022</td>
	<td data-selcondition="Or"><select class="input-sm form-control"
		onchange="conditionChange(this);"><option value="And">Or</option>
			<option value="Or">And</option></select></td>
	<td><label><i class="icon-edit cursor-pointer"
			onclick="editDataSetFilterCondition(this);" title="Edit"></i> <i
			class="icon-delete deletecurrent" title="Delete"
			onclick="deleteDataSetFilterCondition(this);"></i></label></td>
</tr>

<tr data-schemaname="dbo" data-tablename="sysdepends"
	data-typename="Numeric">


	<td style="word-break: break-all;" data-sqlcolumnname="id">dbo.sysdepends.id</td>
	<td style="padding-left: 5px; width: 40%; word-wrap: break-word;" data-sqloperator="=">=</td>
	<td data-value="821577965">821577965</td>
	<td data-selcondition=" OR "><select class="input-sm form-control" onchange="conditionChange(this);">
			<option selected="" value=" OR ">Or</option>
			<option value=" AND ">And</option>
	</select></td>
	<td><label>
	<i class="cursor-pointer icon-edit" onclick="editDataSetFilterCondition(this);" title="Edit"></i> 
	<i class="icon-delete deletecurrent" title="Delete" onclick="deleteDataSetFilterCondition(this);"></i></label></td>
</tr>