drop user &1 cascade;
create user &1 identified by &2;
grant connect,resource to &1;
connect &1/&2;
set define off;

create table Subur_Author (
	authorId number(30,0) not null primary key,
	groupId number(30,0),
	companyId number(30,0),
	title VARCHAR2(75 CHAR) null,
	idType number(30,0),
	remoteId VARCHAR2(75 CHAR) null,
	firstName VARCHAR2(75 CHAR) null,
	lastName VARCHAR2(75 CHAR) null,
	middleName VARCHAR2(75 CHAR) null,
	userId number(30,0),
	metadata VARCHAR2(75 CHAR) null,
	lastPublishedDate timestamp null,
	itemCount number(30,0),
	createDate timestamp null,
	modifiedDate timestamp null,
	Uuid VARCHAR2(75 CHAR) null,
	createdBy number(30,0)
);

create table Subur_AuthorExpertise (
	authorId number(30,0) not null,
	expertiseId number(30,0) not null,
	primary key (authorId, expertiseId)
);

create table Subur_AuthorSite (
	authorSiteId number(30,0) not null primary key,
	authorId number(30,0),
	siteName VARCHAR2(75 CHAR) null,
	siteURL VARCHAR2(150 CHAR) null
);

create table Subur_DownloadSummary (
	id_ number(30,0) not null primary key,
	itemId number(30,0),
	perMonth number(30,0),
	perYear number(30,0),
	status number(30,0)
);

create table Subur_Expertise (
	expertiseId number(30,0) not null primary key,
	groupId number(30,0),
	companyId number(30,0),
	userId number(30,0),
	createDate timestamp null,
	expertiseName VARCHAR2(75 CHAR) null,
	indexedName VARCHAR2(75 CHAR) null,
	modifiedDate timestamp null,
	authorCount number(30,0)
);

create table Subur_Item (
	itemId number(30,0) not null primary key,
	companyId number(30,0),
	groupId number(30,0),
	userId number(30,0),
	userName VARCHAR2(75 CHAR) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	publishedDate timestamp null,
	title VARCHAR2(255 CHAR) null,
	itemAbstract clob null,
	language VARCHAR2(75 CHAR) null,
	status number(30,0),
	Uuid VARCHAR2(75 CHAR) null,
	metadataValue clob null
);

create table Subur_ItemAuthor (
	itemId number(30,0) not null,
	authorId number(30,0) not null,
	primary key (itemId, authorId)
);

create table Subur_ItemFileEntry (
	itemId number(30,0) not null,
	fileEntryId number(30,0) not null,
	entryType number(30,0),
	primary key (itemId, fileEntryId)
);

create table Subur_ItemItemType (
	itemId number(30,0) not null,
	itemTypeId number(30,0) not null,
	primary key (itemId, itemTypeId)
);

create table Subur_ItemType (
	itemTypeId number(30,0) not null primary key,
	itemTypeName VARCHAR2(75 CHAR) null,
	itemCount number(30,0)
);

create table Subur_ItemTypeTemplate (
	itemTypeId number(30,0) not null,
	metadataPropertyId number(30,0) not null,
	required number(1, 0),
	primary key (itemTypeId, metadataPropertyId)
);

create table Subur_MetadataProperty (
	metadataPropertyId number(30,0) not null primary key,
	metadataSchemaId number(30,0),
	element VARCHAR2(255 CHAR) null,
	scope VARCHAR2(255 CHAR) null,
	note VARCHAR2(1024 CHAR) null
);

create table Subur_MetadataPropertyValue (
	metadataPropertyValueId number(30,0) not null primary key,
	itemId number(30,0),
	propertyId number(30,0),
	textValue clob null,
	itemCount number(30,0)
);

create table Subur_MetadataSchema (
	metadataSchemaId number(30,0) not null primary key,
	metadataName VARCHAR2(1024 CHAR) null,
	nameSpace VARCHAR2(75 CHAR) null
);

create table Subur_StatDownloadCategory (
	id_ number(30,0) not null primary key,
	perMonth number(30,0),
	perYear number(30,0),
	categoryId number(30,0)
);

create table Subur_StatDownloadItemType (
	id_ number(30,0) not null primary key,
	perMonth number(30,0),
	perYear number(30,0),
	itemTypeId number(30,0)
);

create table Subur_StatDownloadPeriod (
	id_ number(30,0) not null primary key,
	itemId number(30,0),
	perMonth number(30,0),
	perYear number(30,0)
);

create table Subur_StatDownloadTag (
	id_ number(30,0) not null primary key,
	perMonth number(30,0),
	perYear number(30,0),
	tagId number(30,0)
);

create table Subur_StatViewCategory (
	id_ number(30,0) not null primary key,
	perMonth number(30,0),
	perYear number(30,0),
	categoryId number(30,0)
);

create table Subur_StatViewItemType (
	id_ number(30,0) not null primary key,
	perMonth number(30,0),
	perYear number(30,0),
	itemTypeId number(30,0)
);

create table Subur_StatViewTag (
	id_ number(30,0) not null primary key,
	perMonth number(30,0),
	perYear number(30,0),
	tagId number(30,0)
);

create table Subur_ViewSummary (
	id_ number(30,0) not null primary key,
	itemId number(30,0),
	perMonth number(30,0),
	perYear number(30,0),
	status number(30,0)
);

create table item (
	itemId number(30,0) not null primary key,
	companyId number(30,0),
	groupId number(30,0),
	userId number(30,0),
	userName VARCHAR2(75 CHAR) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	title VARCHAR2(75 CHAR) null,
	itemAbstract VARCHAR2(75 CHAR) null,
	status number(30,0)
);

create table subur_Author (
	authorId number(30,0) not null primary key,
	groupId number(30,0),
	companyId number(30,0),
	title VARCHAR2(75 CHAR) null,
	idType number(30,0),
	remoteId VARCHAR2(75 CHAR) null,
	firstName VARCHAR2(75 CHAR) null,
	lastName VARCHAR2(75 CHAR) null,
	userId number(30,0),
	metadata VARCHAR2(75 CHAR) null,
	lastPublishedDate timestamp null,
	itemCount number(30,0),
	personalSite VARCHAR2(75 CHAR) null,
	googleScholar VARCHAR2(120 CHAR) null
);

create table subur_AuthorExpertise (
	authorId number(30,0) not null,
	expertiseId number(30,0) not null,
	primary key (authorId, expertiseId)
);

create table subur_Division (
	divisionId number(30,0) not null primary key,
	parentId number(30,0),
	divisionName VARCHAR2(75 CHAR) null,
	depositable number(1, 0)
);

create table subur_DownloadSummary (
	id_ number(30,0) not null primary key,
	itemId number(30,0),
	perMonth number(30,0),
	perYear number(30,0),
	status number(30,0)
);

create table subur_Expertise (
	expertiseId number(30,0) not null primary key,
	groupId number(30,0),
	companyId number(30,0),
	userId number(30,0),
	createDate timestamp null,
	expertiseName VARCHAR2(75 CHAR) null,
	indexedName VARCHAR2(75 CHAR) null,
	modifiedDate timestamp null,
	authorCount number(30,0)
);

create table subur_FileEntryType (
	typeId number(30,0) not null primary key,
	typeName VARCHAR2(75 CHAR) null
);

create table subur_Item (
	itemId number(30,0) not null primary key,
	companyId number(30,0),
	groupId number(30,0),
	userId number(30,0),
	userName VARCHAR2(75 CHAR) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	title VARCHAR2(1024 CHAR) null,
	itemAbstract varchar2(4000) null,
	status number(30,0)
);

create table subur_ItemAuthor (
	itemId number(30,0) not null,
	authorId number(30,0) not null,
	primary key (itemId, authorId)
);

create table subur_ItemDivision (
	itemId number(30,0) not null,
	divisionId number(30,0) not null,
	primary key (itemId, divisionId)
);

create table subur_ItemFileEntry (
	itemId number(30,0) not null,
	fileEntryId number(30,0) not null,
	entryType number(30,0),
	primary key (itemId, fileEntryId)
);

create table subur_ItemItemType (
	itemId number(30,0) not null,
	itemTypeId number(30,0) not null,
	primary key (itemId, itemTypeId)
);

create table subur_ItemSubject (
	itemId number(30,0) not null,
	subjectId number(30,0) not null,
	primary key (itemId, subjectId)
);

create table subur_ItemType (
	ItemTypeId number(30,0) not null primary key,
	ItemTypeName VARCHAR2(75 CHAR) null,
	itemCount number(30,0)
);

create table subur_ItemTypeTemplate (
	itemTypeId number(30,0) not null,
	metadataPropertyId number(30,0) not null,
	required number(1, 0),
	primary key (itemTypeId, metadataPropertyId)
);

create table subur_MetadataProperty (
	metadataPropertyId number(30,0) not null primary key,
	metadataSchemaId number(30,0),
	element VARCHAR2(255 CHAR) null,
	scope VARCHAR2(255 CHAR) null,
	note VARCHAR2(1024 CHAR) null
);

create table subur_MetadataPropertyValue (
	metadataPropertyValueId number(30,0) not null primary key,
	itemId number(30,0),
	propertyId number(30,0),
	textValue clob null,
	itemCount number(30,0)
);

create table subur_MetadataSchema (
	metadataSchemaId number(30,0) not null primary key,
	metadataName VARCHAR2(1024 CHAR) null,
	nameSpace VARCHAR2(75 CHAR) null
);

create table subur_MetadataValue (
	metadataValueId number(30,0) not null primary key,
	itemId number(30,0),
	propertyId number(30,0),
	textValue VARCHAR2(75 CHAR) null
);

create table subur_MetadataValueView (
	propertyId number(30,0) not null,
	subjectId number(30,0) not null,
	subjectName VARCHAR2(75 CHAR) null,
	textValue VARCHAR2(75 CHAR) null,
	itemCount number(30,0),
	primary key (propertyId, subjectId)
);

create table subur_StatDownloadCategory (
	id_ number(30,0) not null primary key,
	perMonth number(30,0),
	perYear number(30,0),
	categoryId number(30,0)
);

create table subur_StatDownloadItemType (
	id_ number(30,0) not null primary key,
	perMonth number(30,0),
	perYear number(30,0),
	itemTypeId number(30,0)
);

create table subur_StatDownloadPeriod (
	id_ number(30,0) not null primary key,
	itemId number(30,0),
	perMonth number(30,0),
	perYear number(30,0)
);

create table subur_StatDownloadTag (
	id_ number(30,0) not null primary key,
	perMonth number(30,0),
	perYear number(30,0),
	tagId number(30,0)
);

create table subur_StatViewCategory (
	id_ number(30,0) not null primary key,
	perMonth number(30,0),
	perYear number(30,0),
	categoryId number(30,0)
);

create table subur_StatViewItemType (
	id_ number(30,0) not null primary key,
	perMonth number(30,0),
	perYear number(30,0),
	itemTypeId number(30,0)
);

create table subur_StatViewPeriod (
	id_ number(30,0) not null primary key,
	itemId number(30,0),
	perMonth number(30,0),
	perYear number(30,0)
);

create table subur_StatViewTag (
	id_ number(30,0) not null primary key,
	perMonth number(30,0),
	perYear number(30,0),
	tagId number(30,0)
);

create table subur_Subject (
	subjectId number(30,0) not null primary key,
	parentId number(30,0),
	subjectName VARCHAR2(75 CHAR) null,
	lft number(30,0),
	rgt number(30,0),
	depositable number(1, 0),
	itemCount number(30,0)
);

create table subur_SubjectTree (
	subjectId number(30,0) not null primary key,
	parentId number(30,0),
	subjectName VARCHAR2(75 CHAR) null,
	lft number(30,0),
	rgt number(30,0),
	depositable number(1, 0),
	itemCount number(30,0)
);

create table subur_ViewSummary (
	id_ number(30,0) not null primary key,
	itemId number(30,0),
	perMonth number(30,0),
	perYear number(30,0),
	status number(30,0)
);

create table subur_item (
	itemId number(30,0) not null primary key,
	companyId number(30,0),
	groupId number(30,0),
	userId number(30,0),
	userName VARCHAR2(75 CHAR) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	publishedDate timestamp null,
	title VARCHAR2(255 CHAR) null,
	itemAbstract clob null,
	language VARCHAR2(75 CHAR) null,
	status number(30,0),
	Uuid VARCHAR2(75 CHAR) null,
	metadataValue clob null
);


create index IX_FFFF61F5 on Subur_Author (companyId, groupId);
create index IX_2AF8478 on Subur_Author (firstName);
create index IX_149DFA17 on Subur_Author (groupId);
create index IX_4A5E5E1C on Subur_Author (idType);
create index IX_9DF5FD28 on Subur_Author (lastName);

create index IX_CC54E0E4 on Subur_AuthorExpertise (authorId);
create index IX_305DCC92 on Subur_AuthorExpertise (expertiseId);

create index IX_9690014 on Subur_AuthorSite (authorId);
create unique index IX_278E0FFA on Subur_AuthorSite (authorId, siteName);

create index IX_22012CA4 on Subur_DownloadSummary (itemId);
create index IX_4559BD91 on Subur_DownloadSummary (perMonth, perYear);
create index IX_A4EC2AC8 on Subur_DownloadSummary (perYear);
create index IX_2A706808 on Subur_DownloadSummary (status);

create index IX_E625355 on Subur_Expertise (groupId);
create unique index IX_5FEE7F17 on Subur_Expertise (groupId, indexedName);

create index IX_ED467B0F on Subur_Item (groupId);
create index IX_EDC057E1 on Subur_Item (status);

create index IX_AFE1C520 on Subur_ItemAuthor (authorId);
create index IX_504C54A8 on Subur_ItemAuthor (itemId);

create index IX_578F7669 on Subur_ItemFileEntry (itemId);

create index IX_F6430C4A on Subur_ItemItemType (itemId);
create index IX_131A3C24 on Subur_ItemItemType (itemTypeId);

create index IX_BE8FEB13 on Subur_MetadataPropertyValue (itemId);

create index IX_1714372F on Subur_StatDownloadCategory (categoryId);

create index IX_B3AC994D on Subur_StatDownloadItemType (itemTypeId);

create index IX_649E290E on Subur_StatDownloadPeriod (perMonth, perYear);

create index IX_9BABC163 on Subur_StatDownloadTag (tagId);

create index IX_95E6208C on Subur_StatViewCategory (categoryId);

create index IX_327E82AA on Subur_StatViewItemType (itemTypeId);

create index IX_8B534B00 on Subur_StatViewTag (tagId);

create index IX_A41A932E on Subur_ViewSummary (perMonth, perYear);
create index IX_A1B0F0A5 on Subur_ViewSummary (perYear);
create index IX_C73CF28B on Subur_ViewSummary (status);

create index IX_3793AB1 on item (groupId);
create index IX_28461BFF on item (status);

create index IX_A3F7E5D5 on subur_Author (companyId, groupId);
create index IX_88B92498 on subur_Author (firstName);
create index IX_13641B8D on subur_Author (firstName, lastName);
create index IX_5AD12237 on subur_Author (groupId);
create index IX_852A2991 on subur_Author (groupId, companyId);
create index IX_1B15B1FC on subur_Author (idType);
create index IX_1E27D908 on subur_Author (lastName);

create index IX_874C6104 on subur_AuthorExpertise (authorId);
create index IX_B844D872 on subur_AuthorExpertise (expertiseId);
create index IX_9E529FE0 on subur_AuthorExpertise (groupId);
create unique index IX_6C3A3E0C on subur_AuthorExpertise (groupId, expertiseName);

create index IX_943EF53 on subur_Division (depositable);

create index IX_EF17272F on subur_DownloadSummary (categoryId);
create index IX_BF1A34C4 on subur_DownloadSummary (itemId);
create index IX_D2D4979E on subur_DownloadSummary (itemTypeId);
create index IX_32006171 on subur_DownloadSummary (perMonth, perYear);
create index IX_AAF426A8 on subur_DownloadSummary (perYear);
create index IX_C7897028 on subur_DownloadSummary (status);
create index IX_657D3E43 on subur_DownloadSummary (tagId);

create index IX_498CB735 on subur_Expertise (groupId);
create unique index IX_A61DF217 on subur_Expertise (groupId, expertiseName);
create unique index IX_800D6737 on subur_Expertise (groupId, indexedName);

create index IX_80652B2F on subur_Item (groupId);
create index IX_2FA0D6B7 on subur_Item (itemTypeId);
create index IX_E1FB23C1 on subur_Item (status);

create index IX_CA02B100 on subur_ItemAuthor (authorId);
create index IX_8B76B888 on subur_ItemAuthor (itemId);

create index IX_C367AF84 on subur_ItemDivision (divisionId);
create index IX_FB83BBEA on subur_ItemDivision (itemId);

create index IX_818C0689 on subur_ItemFileEntry (itemId);

create index IX_1063F82A on subur_ItemItemType (itemId);
create index IX_19223804 on subur_ItemItemType (itemTypeId);

create index IX_6791B69F on subur_ItemSubject (itemId);
create index IX_123CC91A on subur_ItemSubject (subjectId);

create index IX_338A5B33 on subur_MetadataPropertyValue (itemId);

create index IX_FAD2530F on subur_StatDownloadCategory (categoryId);

create index IX_976AB52D on subur_StatDownloadItemType (itemTypeId);

create index IX_B8B6792E on subur_StatDownloadPeriod (perMonth, perYear);

create index IX_B1413543 on subur_StatDownloadTag (tagId);

create index IX_1DCD2C6C on subur_StatViewCategory (categoryId);

create index IX_BA658E8A on subur_StatViewItemType (itemTypeId);

create index IX_7DA1F444 on subur_StatViewPeriod (itemId);

create index IX_C67DAEE0 on subur_StatViewTag (tagId);

create index IX_D36F038 on subur_Subject (depositable);

create index IX_F7FB59BA on subur_SubjectTree (depositable);

create index IX_A7C5C832 on subur_ViewSummary (categoryId);
create index IX_E8EFCF47 on subur_ViewSummary (itemId);
create index IX_8B8338A1 on subur_ViewSummary (itemTypeId);
create index IX_CE6E270E on subur_ViewSummary (perMonth, perYear);
create index IX_BBD1DC85 on subur_ViewSummary (perYear);
create index IX_F15F0AAB on subur_ViewSummary (status);
create index IX_6F18C760 on subur_ViewSummary (tagId);

create index IX_BBD2734F on subur_item (groupId);
create index IX_1DB457A1 on subur_item (status);



quit