create table Subur_Author (
	authorId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	title varchar(75) null,
	idType integer,
	remoteId varchar(75) null,
	firstName varchar(75) null,
	lastName varchar(75) null,
	middleName varchar(75) null,
	userId integer,
	metadata varchar(75) null,
	lastPublishedDate timestamp null,
	itemCount integer,
	createDate timestamp null,
	modifiedDate timestamp null,
	Uuid varchar(75) null,
	createdBy bigint
);

create table Subur_AuthorExpertise (
	authorId bigint not null,
	expertiseId bigint not null,
	primary key (authorId, expertiseId)
);

create table Subur_AuthorSite (
	authorSiteId bigint not null primary key,
	authorId bigint,
	siteName varchar(75) null,
	siteURL varchar(150) null
);

create table Subur_DownloadSummary (
	id_ bigint not null primary key,
	itemId bigint,
	perMonth integer,
	perYear integer,
	status integer
);

create table Subur_Expertise (
	expertiseId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	createDate timestamp null,
	expertiseName varchar(75) null,
	indexedName varchar(75) null,
	modifiedDate timestamp null,
	authorCount integer
);

create table Subur_Item (
	itemId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	publishedDate timestamp null,
	title varchar(255) null,
	itemAbstract text null,
	language varchar(75) null,
	status integer,
	Uuid varchar(75) null,
	metadataValue text null
);

create table Subur_ItemAuthor (
	itemId bigint not null,
	authorId bigint not null,
	primary key (itemId, authorId)
);

create table Subur_ItemFileEntry (
	itemId bigint not null,
	fileEntryId bigint not null,
	entryType bigint,
	primary key (itemId, fileEntryId)
);

create table Subur_ItemItemType (
	itemId bigint not null,
	itemTypeId bigint not null,
	primary key (itemId, itemTypeId)
);

create table Subur_ItemType (
	itemTypeId bigint not null primary key,
	itemTypeName varchar(75) null,
	itemCount integer
);

create table Subur_ItemTypeTemplate (
	itemTypeId bigint not null,
	metadataPropertyId bigint not null,
	required bool,
	primary key (itemTypeId, metadataPropertyId)
);

create table Subur_MetadataProperty (
	metadataPropertyId bigint not null primary key,
	metadataSchemaId bigint,
	element varchar(255) null,
	scope varchar(255) null,
	note varchar(1024) null
);

create table Subur_MetadataPropertyValue (
	metadataPropertyValueId bigint not null primary key,
	itemId bigint,
	propertyId bigint,
	textValue text null,
	itemCount integer
);

create table Subur_MetadataSchema (
	metadataSchemaId bigint not null primary key,
	metadataName varchar(1024) null,
	nameSpace varchar(75) null
);

create table Subur_StatDownloadCategory (
	id_ bigint not null primary key,
	perMonth integer,
	perYear integer,
	categoryId bigint
);

create table Subur_StatDownloadItemType (
	id_ bigint not null primary key,
	perMonth integer,
	perYear integer,
	itemTypeId bigint
);

create table Subur_StatDownloadPeriod (
	id_ bigint not null primary key,
	itemId bigint,
	perMonth integer,
	perYear integer
);

create table Subur_StatDownloadTag (
	id_ bigint not null primary key,
	perMonth integer,
	perYear integer,
	tagId bigint
);

create table Subur_StatViewCategory (
	id_ bigint not null primary key,
	perMonth integer,
	perYear integer,
	categoryId bigint
);

create table Subur_StatViewItemType (
	id_ bigint not null primary key,
	perMonth integer,
	perYear integer,
	itemTypeId bigint
);

create table Subur_StatViewTag (
	id_ bigint not null primary key,
	perMonth integer,
	perYear integer,
	tagId bigint
);

create table Subur_ViewSummary (
	id_ bigint not null primary key,
	itemId bigint,
	perMonth integer,
	perYear integer,
	status integer
);

create table item (
	itemId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	title varchar(75) null,
	itemAbstract varchar(75) null,
	status integer
);

create table subur_Author (
	authorId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	title varchar(75) null,
	idType integer,
	remoteId varchar(75) null,
	firstName varchar(75) null,
	lastName varchar(75) null,
	userId integer,
	metadata varchar(75) null,
	lastPublishedDate timestamp null,
	itemCount integer,
	personalSite varchar(75) null,
	googleScholar varchar(120) null
);

create table subur_AuthorExpertise (
	authorId bigint not null,
	expertiseId bigint not null,
	primary key (authorId, expertiseId)
);

create table subur_Division (
	divisionId bigint not null primary key,
	parentId bigint,
	divisionName varchar(75) null,
	depositable bool
);

create table subur_DownloadSummary (
	id_ bigint not null primary key,
	itemId bigint,
	perMonth integer,
	perYear integer,
	status integer
);

create table subur_Expertise (
	expertiseId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	createDate timestamp null,
	expertiseName varchar(75) null,
	indexedName varchar(75) null,
	modifiedDate timestamp null,
	authorCount integer
);

create table subur_FileEntryType (
	typeId bigint not null primary key,
	typeName varchar(75) null
);

create table subur_Item (
	itemId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	title varchar(1024) null,
	itemAbstract text null,
	status integer
);

create table subur_ItemAuthor (
	itemId bigint not null,
	authorId bigint not null,
	primary key (itemId, authorId)
);

create table subur_ItemDivision (
	itemId bigint not null,
	divisionId bigint not null,
	primary key (itemId, divisionId)
);

create table subur_ItemFileEntry (
	itemId bigint not null,
	fileEntryId bigint not null,
	entryType bigint,
	primary key (itemId, fileEntryId)
);

create table subur_ItemItemType (
	itemId bigint not null,
	itemTypeId bigint not null,
	primary key (itemId, itemTypeId)
);

create table subur_ItemSubject (
	itemId bigint not null,
	subjectId bigint not null,
	primary key (itemId, subjectId)
);

create table subur_ItemType (
	ItemTypeId bigint not null primary key,
	ItemTypeName varchar(75) null,
	itemCount integer
);

create table subur_ItemTypeTemplate (
	itemTypeId bigint not null,
	metadataPropertyId bigint not null,
	required bool,
	primary key (itemTypeId, metadataPropertyId)
);

create table subur_MetadataProperty (
	metadataPropertyId bigint not null primary key,
	metadataSchemaId bigint,
	element varchar(255) null,
	scope varchar(255) null,
	note varchar(1024) null
);

create table subur_MetadataPropertyValue (
	metadataPropertyValueId bigint not null primary key,
	itemId bigint,
	propertyId bigint,
	textValue text null,
	itemCount integer
);

create table subur_MetadataSchema (
	metadataSchemaId bigint not null primary key,
	metadataName varchar(1024) null,
	nameSpace varchar(75) null
);

create table subur_MetadataValue (
	metadataValueId bigint not null primary key,
	itemId bigint,
	propertyId bigint,
	textValue varchar(75) null
);

create table subur_MetadataValueView (
	propertyId bigint not null,
	subjectId bigint not null,
	subjectName varchar(75) null,
	textValue varchar(75) null,
	itemCount integer,
	primary key (propertyId, subjectId)
);

create table subur_StatDownloadCategory (
	id_ bigint not null primary key,
	perMonth integer,
	perYear integer,
	categoryId bigint
);

create table subur_StatDownloadItemType (
	id_ bigint not null primary key,
	perMonth integer,
	perYear integer,
	itemTypeId bigint
);

create table subur_StatDownloadPeriod (
	id_ bigint not null primary key,
	itemId bigint,
	perMonth integer,
	perYear integer
);

create table subur_StatDownloadTag (
	id_ bigint not null primary key,
	perMonth integer,
	perYear integer,
	tagId bigint
);

create table subur_StatViewCategory (
	id_ bigint not null primary key,
	perMonth integer,
	perYear integer,
	categoryId bigint
);

create table subur_StatViewItemType (
	id_ bigint not null primary key,
	perMonth integer,
	perYear integer,
	itemTypeId bigint
);

create table subur_StatViewPeriod (
	id_ bigint not null primary key,
	itemId bigint,
	perMonth integer,
	perYear integer
);

create table subur_StatViewTag (
	id_ bigint not null primary key,
	perMonth integer,
	perYear integer,
	tagId bigint
);

create table subur_Subject (
	subjectId bigint not null primary key,
	parentId bigint,
	subjectName varchar(75) null,
	lft integer,
	rgt integer,
	depositable bool,
	itemCount integer
);

create table subur_SubjectTree (
	subjectId bigint not null primary key,
	parentId bigint,
	subjectName varchar(75) null,
	lft integer,
	rgt integer,
	depositable bool,
	itemCount integer
);

create table subur_ViewSummary (
	id_ bigint not null primary key,
	itemId bigint,
	perMonth integer,
	perYear integer,
	status integer
);

create table subur_item (
	itemId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	publishedDate timestamp null,
	title varchar(255) null,
	itemAbstract text null,
	language varchar(75) null,
	status integer,
	Uuid varchar(75) null,
	metadataValue text null
);
